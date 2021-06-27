package com.assetmanagement.demo.democontroller;

import com.assetmanagement.demo.model.Category;
import com.assetmanagement.demo.model.asset;
import com.assetmanagement.demo.service.assetService;
import com.assetmanagement.demo.service.categoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class assetController {

    @Autowired
    assetService assetService;
    
    @Autowired
    categoryService categoryService;

    @GetMapping("/asset")
    private List<asset> getAllasset()
    {

        return assetService.getAllAsset();
    }
    @GetMapping("/asset/{id}")
    private asset getAsset(@PathVariable("id") int name)
    {

        return assetService.getAssetById(name);
    }

    @DeleteMapping
    private void deleteAsset(@PathVariable("id") int name)
    {
        assetService.delete(name);
    }

    @PostMapping("/updateAsset")
    private int updateAsset(asset asset)
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
