package com.assetmanagement.demo.service;

import com.assetmanagement.demo.model.Asset;
import com.assetmanagement.demo.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssetService {

    @Autowired
    AssetRepository assetRepository;

    public List<Asset> getAllAsset() {
        List<Asset> assets = new ArrayList<Asset>();
        assetRepository.findAll().forEach(asset -> assets.add((Asset) asset));
        return assets;
    }

    public Asset getAssetById(int id) {   	
    	Asset obj =  getDataById(id);
    	 return obj;
    }
    
	public Asset getDataById(int id) {
		 return assetRepository.findById(id).get();
	}
    public void delete(int id){
        assetRepository.deleteById(id);
    }

    public void saveOrUpdate(Asset asset) {
        assetRepository.save(asset);
    }

    public void assignAsset(String name, int empID) {
        Asset asset = getAssetById(empID);
        asset.setAssignmentStatus("Assigned");
        asset.setAssignedEmployeeId(empID);
        saveOrUpdate(asset);
    }

    public void recoverAsset(int id) {
        Asset asset = getAssetById(id);
        asset.setAssignmentStatus("Recovered");
        saveOrUpdate(asset);
    }
}
