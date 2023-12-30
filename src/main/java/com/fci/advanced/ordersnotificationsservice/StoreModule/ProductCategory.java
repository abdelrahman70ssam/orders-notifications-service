package com.fci.advanced.ordersnotificationsservice.StoreModule;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductCategory {

    private HashMap<String , List<Product>> categories = new HashMap<>();

    public HashMap<String, List<Product>> getCategories() {
        return categories;
    }


    public void addProductTocategory(Product product){
       List<Product>productList = categories.computeIfAbsent(product.getCategory(),k->new ArrayList<>());
       productList.add(product);
    }
}
