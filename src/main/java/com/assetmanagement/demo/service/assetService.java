package com.assetmanagement.demo.service;

import com.assetmanagement.demo.model.asset;
import com.assetmanagement.demo.repository.assetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class assetService {

    @Autowired
    assetRepository assetRepository;

    public List<asset> getAllAsset() {
        List<asset> assets = new ArrayList<asset>();
        assetRepository.findAll().forEach(asset -> assets.add((asset) asset));
        return assets;
    }

    public asset getAssetById(int id) {
        return assetRepository.findById(id).get();
    }

    public void delete(int id){
        assetRepository.deleteById(id);
    }

    public void saveOrUpdate(asset asset) {
        assetRepository.save(asset);
    }

    public void assignAsset(String name, int empID) {
        asset asset = getAssetById(empID);
        asset.setAssignmentStatus("Assigned");
        asset.setAssignedEmployeeId(empID);
        saveOrUpdate(asset);
    }

    public void recoverAsset(int id) {
        asset asset = getAssetById(id);
        asset.setAssignmentStatus("Recovered");
        saveOrUpdate(asset);
    }
}
