package com.sprint.btb.ctrl;

import com.sprint.btb.model.AddressModel;
import com.sprint.btb.model.BookingDetailsModel;
import com.sprint.btb.model.BookingModel;
import com.sprint.btb.model.CustomerModel;

import com.sprint.btb.model.LoginModel;
import com.sprint.btb.service.BookingService;
import com.sprint.btb.service.CustomerService;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	//---------------------------------------MY BOOKINGS-----------------------------------------

	private static final String BOOKING_SERVICE_URL ="http://localhost:9093/api/bookings";
	private static final String TRIP_SERVICE_URL = "http://localhost:9093/api/trips/";
	private static final String ROUTE_SERVICE_URL = "http://localhost:9093/api/routes";
	private static final String BUS_SERVICE_URL = "http://localhost:9093/api/buses/";
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/customerBookings")
	public String getBookingsByCustomerId(@RequestParam("customerId") int customerId, Model model) {
		try {
			Set<BookingDetailsModel> bookings = bookingService.getBookingDetailsByCustomerId(customerId);
			model.addAttribute("bookings", bookings);
			model.addAttribute("customerId", customerId);
		} catch (Exception e) {
			model.addAttribute("error","Error fetching bookings: "+ e.getMessage());
		}
		return "customerBookings";
	}
	
	@PostMapping("/cancelBooking")
	public ModelAndView cancelBooking(@RequestParam("bookingId") int bookingId, @RequestParam("customerId") int customerId, RedirectAttributes redirectAttributes) {
	    String url = BOOKING_SERVICE_URL + "/cancel/" + bookingId;
	    try {
	        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, null, String.class);
	        redirectAttributes.addFlashAttribute("success", response.getBody());
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("error", "Error canceling booking: " + e.getMessage());
	    }
	    return new ModelAndView("redirect:/customerBookings?customerId=" + customerId);
	}
	

}
