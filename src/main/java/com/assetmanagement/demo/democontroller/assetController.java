package com.assetmanagement.demo.democontroller;

import com.assetmanagement.demo.model.asset;
import com.assetmanagement.demo.service.assetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class assetController {

    @Autowired
    assetService assetService;

    @GetMapping("/asset")
    private List<asset> getAllasset()
    {

        return assetService.getAllAsset();
    }
    @GetMapping("/asset/{id}")
    private asset getAsset(@PathVariable("id") String name)
    {

        return assetService.getAssetById(name);
    }

    @DeleteMapping
    private void deleteAsset(@PathVariable("id") String name)
    {
        assetService.delete(name);
    }

    @PostMapping
    private String updateAsset(asset asset)
    {
        assetService.saveOrUpdate(asset);
        return asset.getName();
    }

   


}
