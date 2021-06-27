package com.assetmanagement.demo.repository;

import com.assetmanagement.demo.model.asset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface assetRepository extends CrudRepository<asset,String> {
}
