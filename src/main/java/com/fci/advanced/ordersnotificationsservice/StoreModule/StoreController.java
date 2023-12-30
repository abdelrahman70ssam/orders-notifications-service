package com.fci.advanced.ordersnotificationsservice.StoreModule;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
//@RequestMapping("/products")
public class StoreController {

    private StoreBSL storeBSL;


    @Autowired
    public StoreController(StoreBSL storeBSL) {
        this.storeBSL = storeBSL;
    }

//    public StoreController() {
//        storeBSL = new StoreBSL();
//    }


    @GetMapping("/products/all")
    public ResponseEntity<String> listAllProducts()
    {
        ArrayList<Product> productList = storeBSL.getStore().getProducts();  // Replace this with your method to retrieve products

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(productList);

            return ResponseEntity.status(HttpStatus.OK).body(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing JSON");
        }

    }


    @GetMapping("/products/allByCategory")
    public ResponseEntity<String> listAllProductsByCategory()
    {
       ProductCategory productCategory = storeBSL.getStore().getAllProductsByCategory();  // Replace this with your method to retrieve products

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(productCategory);

            return ResponseEntity.status(HttpStatus.OK).body(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing JSON");
        }

    }
}
