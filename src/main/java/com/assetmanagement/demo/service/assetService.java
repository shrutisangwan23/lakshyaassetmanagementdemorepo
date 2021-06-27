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

    public asset getAssetById(String name) {
        return assetRepository.findById(name).get();
    }

    public void delete(String name){
        assetRepository.deleteById(name);
    }

    public void saveOrUpdate(asset asset) {
        assetRepository.save(asset);
    }

    public void assignAsset(String name, int empID) {
        asset asset = getAssetById(name);
        asset.setAssignmentStatus("Assigned");
        asset.setAssignedEmployeeId(empID);
        saveOrUpdate(asset);
    }

    public void recoverAsset(String name) {
        asset asset = getAssetById(name);
        asset.setAssignmentStatus("Recovered");
        saveOrUpdate(asset);
    }
}
