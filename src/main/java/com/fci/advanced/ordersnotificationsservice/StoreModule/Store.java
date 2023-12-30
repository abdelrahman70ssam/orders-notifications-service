package com.fci.advanced.ordersnotificationsservice.StoreModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class Store {
    private ProductCategory productCategory;
    private ArrayList<Product>products;

    @Autowired
    public Store(ProductCategory productCategory, ArrayList<Product> products) {
        this.productCategory = productCategory;
        this.products = products;
    }

    public void initStore()
    {
        for (Product product : products) {
            productCategory.addProductTocategory(product);
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ProductCategory getAllProductsByCategory() {
        return productCategory;
    }


}
