package com.fci.advanced.ordersnotificationsservice.CustomerModule;


import com.fci.advanced.ordersnotificationsservice.DBCustomer.CustomerDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginValidation {
    CustomerDatabase database;


//    @Autowired
    public  LoginValidation(CustomerDatabase database) {
        this.database = database;
    }

    public boolean isValidAccount(String username , String password){
        Customer customer = null;
        customer = database.searchAccount(username,password);
        return (customer != null) ;
    }
}
