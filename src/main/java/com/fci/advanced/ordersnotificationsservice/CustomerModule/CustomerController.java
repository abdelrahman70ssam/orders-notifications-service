package com.fci.advanced.ordersnotificationsservice.CustomerModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    private CustomerBSL customerBSL;

    @Autowired
    public CustomerController(CustomerBSL customerBSL) {
        this.customerBSL = customerBSL;
    }

//    @GetMapping("/hello")
//    public String helloworldmessage()
//    {
//        return "hello World";
//    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomerAPI(@RequestBody Customer customer) {
        String response = customerBSL.registerCustomer(customer);
        if (response.equals("success")) {
            return ResponseEntity.status(HttpStatus.OK).body("data entered successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/sendOTP")
    public ResponseEntity<String> sendOTPAPI() {
        String otp = customerBSL.getRegisterationValidation().sendOTP();
        return ResponseEntity.ok(otp);
    }

    @PostMapping(value = "/verifyOTP/{otp}")
    public ResponseEntity<String> verifyOTPAPI(@PathVariable("otp") String otp , @RequestBody Customer customer) {
        boolean isOTPVerified = customerBSL.getRegisterationValidation().verifyOTP(otp);

        if (isOTPVerified) {
            customerBSL.addCustomer(customer);
            return ResponseEntity.status(HttpStatus.OK).body("Verified OTP :)");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Verified OTP :(");
    }

    @PostMapping(value = "/login/{username}/{password}")
    public ResponseEntity<String>loginCustomerAPI(@PathVariable("username") String username , @PathVariable("password") String password){
        boolean isAccountFound = customerBSL.getLoginValidation().isValidAccount(username,password);
        if(isAccountFound){
             return ResponseEntity.status(HttpStatus.OK).body("logged in Successfully");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid username or password , try again");
    }
}
