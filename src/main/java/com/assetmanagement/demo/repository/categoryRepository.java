package com.assetmanagement.demo.repository;

import com.assetmanagement.demo.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryRepository extends CrudRepository<Category,Integer> {
}
