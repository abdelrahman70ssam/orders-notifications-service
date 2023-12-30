package com.fci.advanced.ordersnotificationsservice.CustomerModule;

import com.fci.advanced.ordersnotificationsservice.DBCustomer.CustomerDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class RegisterationValidation {
    private CustomerDatabase database;
    private String otp ;

    @Autowired
    public RegisterationValidation(CustomerDatabase database) {
        this.database = database;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getOtp() {
        return otp;
    }

    public String register(Customer customer)
    {
        if(!verifyUsername(customer.getUsername())){
            return "should enter Unique name";
        }
        if(!verifyMail(customer.getEmail())){
            return "Not valid mail";
        }
        if (!checkPasswordComplexity(customer.getPassword())){
            return "Not complex password";
        }
        if (!verifyPhoneNumber(customer.getPhoneNubmer())){
            return "Not valid Phone Number";
        }

        if(!verifyBalance(customer.getBalance())){
            return "Not sufficeient Balance" ;
        }

        return "success";
    }
    public boolean verifyUsername(String username)
    {
        return (database.isUniqueUsername(username));
    }
    public boolean verifyMail(String email) {
        String emailRegex = "^[a-z]+@gmail\\.com$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public boolean checkPasswordComplexity(String password)
    {
        String passwordRegex = "[a-z]+[0-9]+";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public boolean verifyPhoneNumber(String phoneNumber){
        String phoneRegex = "^01[0125][0-9]{8}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    public String sendOTP(){
        Random random = new Random();
        Long num = random.nextLong(0,1000000);
        this.otp = String.valueOf(num);
        return this.otp;
    }

    public boolean verifyOTP(String otp)
    {
        if(otp == null)
            return false;
        return (otp.equals(this.otp));
    }

    public boolean verifyBalance(double balance){
        return (balance > 0);
    }


}
