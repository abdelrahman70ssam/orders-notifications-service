package com.fci.advanced.ordersnotificationsservice.DBCustomer;

import com.fci.advanced.ordersnotificationsservice.CustomerModule.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CustomerDatabase {
    private ArrayList<Customer> accountsDB = new ArrayList<>();

    public CustomerDatabase() {
        this.accountsDB = new ArrayList<>();
    }

    public void addCustomerToDB(Customer customer){
        customer.setAccountStatus(true);
        accountsDB.add(customer);
    }

    public void removeCustomerFromDB(Customer customer)
    {
        customer.setAccountStatus(false);
        accountsDB.remove(customer);
    }
    public boolean isUniqueUsername(String username)
    {
        for(Customer account : accountsDB)
        {
            if(account.getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }

    public Customer searchAccount(String username , String password)
    {
        for(Customer account : accountsDB)
        {
            if(account.getUsername().equals(username) && account.getPassword().equals(password)){
                return account;
            }
        }
        return null;
    }
}
