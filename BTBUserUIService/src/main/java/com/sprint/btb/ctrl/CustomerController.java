package com.sprint.btb.ctrl;

import com.sprint.btb.model.AddressModel;

import com.sprint.btb.model.CustomerModel;

import com.sprint.btb.model.LoginModel;

import com.sprint.btb.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

@Controller

public class CustomerController {

	@Autowired

	private CustomerService customerService;

	// Serve the login page

	@GetMapping("/login")

	public String showLoginPage() {

		return "login"; // Return login.html template

	}

	// Serve the registration page

	@GetMapping("/register")

	public String showRegisterPage() {

		return "register"; // Return register.html template

	}

	@Autowired

	private RestTemplate restTemplate;

	private static final String ADDRESS_SERVICE_URL = "http://localhost:9091/api/addresses"; // Address Microservice URL

	@PostMapping("/register")

	public String register(@RequestParam String name,

			@RequestParam String email,

			@RequestParam String phone,

			@RequestParam String password,

			@RequestParam String address,

			@RequestParam String city,

			@RequestParam String state,

			@RequestParam String zipCode,

			Model model) {

		// 1. Create Address in Address Microservice

		AddressModel addressModel = new AddressModel(address, city, state, zipCode);

		AddressModel createdAddress = restTemplate.postForObject(ADDRESS_SERVICE_URL + "/add", addressModel,
				AddressModel.class);

		// 2. Create Customer in Customer Microservice with the address_id

		CustomerModel customerModel = new CustomerModel(name, email, phone, createdAddress.getAddressId(), password);

		customerService.registerCustomer(customerModel);

		// 3. Add success message to the model and redirect to login page

		model.addAttribute("message", "Registration successful! Please log in.");

		return "login"; // Redirect to login page after registration

	}

	// Handle login form submission

	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, Model model) {
		LoginModel loginModel = new LoginModel();
		loginModel.setEmail(email);
		loginModel.setPassword(password);

		try {
			CustomerModel loggedInCustomer = customerService.loginCustomer(loginModel);
			if (loggedInCustomer != null) {
				return "redirect:/index"; // Redirect to the dashboard or homepage
			} else {
				model.addAttribute("error", "Invalid email or password");
				return "login";
			}
		} catch (RuntimeException e) {
			model.addAttribute("error", "Something went wrong. Please check your credentials or try again later.");
			return "login";
		}
	}

}
