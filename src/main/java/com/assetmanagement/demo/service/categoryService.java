package com.assetmanagement.demo.service;

import com.assetmanagement.demo.model.Category;
import com.assetmanagement.demo.repository.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.assetmanagement.demo.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    categoryRepository categoryRepository;

    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).get();
    }

    public void saveOrUpdate(Category category) {
        categoryRepository.save(category);
    }
}
