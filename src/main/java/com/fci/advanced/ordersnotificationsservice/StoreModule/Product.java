package com.fci.advanced.ordersnotificationsservice.StoreModule;

public class Product {
    private String serialNO , name , vendor , category  ;
    private double price;

    public Product(String serialNO, String name, String vendor, String category, double price) {
        this.serialNO = serialNO;
        this.name = name;
        this.vendor = vendor;
        this.category = category;
        this.price = price;
    }

    public void setSerialNO(String serialNO) {
        this.serialNO = serialNO;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getSerialNO() {
        return serialNO;
    }

    public String getName() {
        return name;
    }

    public String getVendor() {
        return vendor;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}
