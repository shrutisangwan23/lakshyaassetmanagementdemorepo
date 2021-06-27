package com.assetmanagement.demo.repository;

import com.assetmanagement.demo.model.Asset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends CrudRepository<Asset,Integer> {
}
