package com.assetmanagement.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.assetmanagement.demo.democontroller.AssetController;
import com.assetmanagement.demo.model.Asset;
import com.assetmanagement.demo.service.AssetService;

public class assetControllerTest {

    @InjectMocks                        //Injecting Mocks in assetController class
    AssetController assetController;

    @Mock                           //Mocking the assetService class
    AssetService assetService;

   
    Asset asset = new Asset();

    //Setup function to run before each mock test
    @BeforeEach
    void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        Asset asset = new Asset();
        asset.setAssignedEmployeeId(12);
        asset.setName("John Doe");
        asset.setPurchaseDate(new Date("31/12/1998"));
        asset.setConditionNotes("Used but in good condition");
        asset.setCategory("Laptop");
        asset.setAssignmentStatus("assigned");
    }

    //Test function to test getAsset

    @Test
    final void testGetAsset() {
        when(assetService.getAssetById(anyInt())).thenReturn(asset);

        Asset assetNew = assetController.getAsset(12);

      //  assertNotNull(assetNew);
        assertEquals(asset.getAssignedEmployeeId(), assetNew.getAssignedEmployeeId());
        assertEquals(asset.getName(), assetNew.getName());
        assertEquals(asset.getAssignmentStatus(), assetNew.getAssignmentStatus());
        assertEquals(asset.getPurchaseDate(), assetNew.getPurchaseDate());
       assertEquals(asset.getConditionNotes(), assetNew.getConditionNotes());
       assertEquals(asset.getCategory(), assetNew.getConditionNotes());
    }

}
