package com.assetmanagement.demo.democontroller;

import com.assetmanagement.demo.model.Category;
import com.assetmanagement.demo.model.Asset;
import com.assetmanagement.demo.service.AssetService;
import com.assetmanagement.demo.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssetController {

    @Autowired
    AssetService assetService;
    
    @Autowired
    CategoryService categoryService;

    @GetMapping("/asset")
    private List<Asset> getAllasset()
    {

        return assetService.getAllAsset();
    }
    @GetMapping("/asset/{id}")
    public Asset getAsset(@PathVariable("id") int name)
    {

        return assetService.getAssetById(name);
    }

    @DeleteMapping
    private void deleteAsset(@PathVariable("id") int name)
    {
        assetService.delete(name);
    }

    @PostMapping("/updateAsset")
    private int updateAsset(Asset asset)
    {
        assetService.saveOrUpdate(asset);
        return asset.getAssignedEmployeeId();
    }

   

    @GetMapping("/category/{id}")
    private Category getCategory(@PathVariable("id") int id){

        return categoryService.getCategoryById(id);
    }

    @PostMapping("/updateCategory")
    private int updateCategoryAsset(Category category)
    {
        categoryService.saveOrUpdate(category);
        return category.getId();
    }


}
