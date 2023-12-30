package com.fci.advanced.ordersnotificationsservice.CustomerModule;


public class Customer {
    private String name ,username , password , email , phoneNumber;
    private double balance ;
    private boolean accountStatus ;

    public Customer(String name, String username, String password, String email, String phoneNumber, double balance) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNubmer() {
        return phoneNumber;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNubmer(String phoneNubmer) {
        this.phoneNumber = phoneNubmer;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }
}
