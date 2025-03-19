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
import org.springframework.http.MediaType;
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
		ResponseEntity<CustomerModel> response = restTemplate.exchange(url, HttpMethod.POST, request,
				CustomerModel.class);
		return response.getBody(); // Return the registered customer data
	}

	// Login customer (via /login endpoint of customer microservice)

	public CustomerModel loginCustomer(LoginModel loginModel) {
		String url = CUSTOMER_SERVICE_URL + "/login";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<LoginModel> request = new HttpEntity<>(loginModel, headers);

		try {
			ResponseEntity<CustomerModel> response = restTemplate.exchange(url, HttpMethod.POST, request,
					CustomerModel.class);

			// Ensure the response body is not null before returning
			if (response.getBody() != null) {
				return response.getBody();
			} else {
				throw new RuntimeException("Login failed: No customer data returned");
			}
		} catch (HttpClientErrorException.Unauthorized e) {
			throw new RuntimeException("Unauthorized access: Invalid credentials");
		} catch (HttpClientErrorException.NotFound e) {
			throw new RuntimeException("Customer not found: Please register first");
		} catch (Exception e) {
			throw new RuntimeException("Error during login: " + e.getMessage());
		}
	}

	// Fetch customer details by customer ID
	public CustomerModel getCustomerDetails(Long customerId) {
		String url = CUSTOMER_SERVICE_URL + "/" + customerId;

		try {
			ResponseEntity<CustomerModel> response = restTemplate.exchange(url, HttpMethod.GET, null,
					CustomerModel.class);
			return response.getBody();
		} catch (HttpClientErrorException.NotFound e) {
			throw new RuntimeException("Customer not found");
		} catch (Exception e) {
			throw new RuntimeException("Error fetching customer details: " + e.getMessage());
		}
	}

}
