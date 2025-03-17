package com.sprint.btb.service;
 
import com.sprint.btb.model.CustomerModel;

import com.sprint.btb.model.LoginModel;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.client.HttpClientErrorException;

import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpEntity;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
 
@Service

public class CustomerService {
 
    private static final String CUSTOMER_SERVICE_URL = "http://localhost:9092/api/customers";
 
    @Autowired

    private RestTemplate restTemplate;
 
    // Register customer (via /create endpoint of customer microservice)

    public CustomerModel registerCustomer(CustomerModel customerModel) {

        String url = CUSTOMER_SERVICE_URL + "/create";

        HttpHeaders headers = new HttpHeaders();

        headers.set("Content-Type", "application/json");
 
        HttpEntity<CustomerModel> request = new HttpEntity<>(customerModel, headers);

        ResponseEntity<CustomerModel> response = restTemplate.exchange(url, HttpMethod.POST, request, CustomerModel.class);
 
        return response.getBody(); // Return the registered customer data

    }
 
    // Login customer (via /login endpoint of customer microservice)

    public CustomerModel loginCustomer(LoginModel loginModel) {

        String url = CUSTOMER_SERVICE_URL + "/login";

        HttpHeaders headers = new HttpHeaders();

        headers.set("Content-Type", "application/json");
 
        HttpEntity<LoginModel> request = new HttpEntity<>(loginModel, headers);
 
        try {

            // Attempt to log in the customer by calling the login endpoint

            ResponseEntity<CustomerModel> response = restTemplate.exchange(url, HttpMethod.POST, request, CustomerModel.class);

            return response.getBody(); // Return the logged-in customer data (if valid)

        } catch (HttpClientErrorException.Unauthorized e) {

            // Handle 401 Unauthorized error

            throw new RuntimeException("Unauthorized access: Invalid credentials");

        } catch (Exception e) {

            // Handle other errors (e.g., 500, network issues, etc.)

            throw new RuntimeException("Error during login: " + e.getMessage());

        }

    }

}

 