package com.fci.advanced.ordersnotificationsservice.StoreModule;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StoreBSL {

    private Store store;

    @Autowired
    public StoreBSL(ProductCategory productCategory) {
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product("SN002", "Smartphone", "Samsung", "Electronics", 500));
        productList.add(new Product("SN003", "Bluetooth Speaker", "JBL", "Electronics", 80));

        // Appliances
        productList.add(new Product("SN004", "Coffee Maker", "Breville", "Appliances", 150));
        productList.add(new Product("SN005", "Cookware Set", "Cuisinart", "Appliances", 200));
        productList.add(new Product("SN006", "Desk Chair", "IKEA", "Appliances", 150));

        // Footwear
        productList.add(new Product("SN007", "Running Shoes", "Nike", "Footwear", 130));
        productList.add(new Product("SN008", "Backpack", "North Face", "Footwear", 80));
        productList.add(new Product("SN009", "Smartwatch", "Apple", "Footwear", 350));

        // Kitchen
        productList.add(new Product("SN010", "Digital Camera", "Canon", "Kitchen", 600));
        productList.add(new Product("SN011", "Toaster", "KitchenAid", "Kitchen", 40));
        productList.add(new Product("SN012", "Blender", "Vitamix", "Kitchen", 250));

        store = new Store(productCategory, productList);
        store.initStore();
    }


    public Store getStore() {
        return store;
    }
}
