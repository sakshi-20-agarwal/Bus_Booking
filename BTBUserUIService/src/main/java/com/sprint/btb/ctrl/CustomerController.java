package com.sprint.btb.ctrl;

import com.sprint.btb.model.AddressModel;
import com.sprint.btb.model.BookingDetailsModel;
import com.sprint.btb.model.BookingModel;
import com.sprint.btb.model.CustomerModel;

import com.sprint.btb.model.LoginModel;
import com.sprint.btb.service.BookingService;
import com.sprint.btb.service.CustomerService;

import jakarta.servlet.http.HttpSession;

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
	
	@Autowired
	private HttpSession session;

	// Serve the login page
	@GetMapping("/login")
	public String showLoginPage() {
		return "login"; // Return login.html template
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
					 session.setAttribute("loggedInCustomer", loggedInCustomer); 
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
		
		
	
	@PostMapping("/validateUser")
	public String validateUser(@ModelAttribute("loginObj") LoginModel loginModel, Model model, HttpSession session) {
	    try {
	        CustomerModel customer = customerService.loginCustomer(loginModel);
	        session.setAttribute("loggedInCustomer", customer);  // Store in session
	        return "redirect:/index";  // Redirect to home page after successful login
	    } catch (RuntimeException e) {
	        model.addAttribute("error", e.getMessage());
	        return "login";  // Show login page with error message
	    }
	}
	
	 @GetMapping("/profile")
	    public String showProfilePage(HttpSession session, Model model) {
	        CustomerModel customer = (CustomerModel) session.getAttribute("loggedInCustomer");
	        if (customer == null) {
	        	 return "redirect:/login";
	        }
	            model.addAttribute("customerName", customer.getName());
	            model.addAttribute("customerEmail", customer.getEmail());
	            model.addAttribute("customerPhone", customer.getPhone());
	            return "profile";
	        
	    }
	

	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate();  // Clears session
	    return "redirect:/home";  // Redirect to login page
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
try {
		// 1. Create Address in Address Microservice
		AddressModel addressModel = new AddressModel(address, city, state, zipCode);
		AddressModel createdAddress = restTemplate.postForObject(ADDRESS_SERVICE_URL + "/add", addressModel,
				AddressModel.class);

		if (createdAddress == null || createdAddress.getAddressId()<0) {
            model.addAttribute("error", "Address creation failed. Please try again.");
            return "register";
        }
		
		// 2. Create Customer in Customer Microservice with the address_id
		CustomerModel customerModel = new CustomerModel(name, email, phone, createdAddress.getAddressId(), password);
		customerService.registerCustomer(customerModel);

		// 3. Add success message to the model and redirect to login page
		model.addAttribute("message", "Registration successful! Please log in.");
		return "login"; // Redirect to login page after registration
	}
catch(Exception e)
{
	 model.addAttribute("error", "Registration failed: " + e.getMessage());
     return "register";
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
	public String getBookingsByCustomerId(HttpSession session, Model model) {
	    CustomerModel customer = (CustomerModel) session.getAttribute("loggedInCustomer");
	    if (customer == null) {
	        return "redirect:/login"; // Redirect if not logged in
	    }
	    
	    try {
	        Set<BookingDetailsModel> bookings = bookingService.getBookingDetailsByCustomerId(customer.getCustomerId());
	        model.addAttribute("bookings", bookings);
	    } catch (Exception e) {
	        model.addAttribute("error","Error fetching bookings: "+ e.getMessage());
	    }
	    return "customerBookings";
	}
	
//	@GetMapping("/customerBookings")
//	public String getBookingsByCustomerId(@RequestParam("customerId") int customerId, Model model) {
//		try {
//			Set<BookingDetailsModel> bookings = bookingService.getBookingDetailsByCustomerId(customerId);
//			model.addAttribute("bookings", bookings);
//			model.addAttribute("customerId", customerId);
//		} catch (Exception e) {
//			model.addAttribute("error","Error fetching bookings: "+ e.getMessage());
//		}
//		return "customerBookings";
//	}
	
	@PostMapping("/cancelBooking")
	public ModelAndView cancelBooking(@RequestParam("bookingId") int bookingId, HttpSession session, RedirectAttributes redirectAttributes) {
	    CustomerModel customer = (CustomerModel) session.getAttribute("loggedInCustomer");
	    if (customer == null) {
	        return new ModelAndView("redirect:/login");
	    }
	    
	    String url = BOOKING_SERVICE_URL + "/cancel/" + bookingId;
	    try {
	        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, null, String.class);
	        redirectAttributes.addFlashAttribute("success", response.getBody());
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("error", "Error canceling booking: " + e.getMessage());
	    }
	    return new ModelAndView("redirect:/customerBookings");
	}

	
//	@PostMapping("/cancelBooking")
//	public ModelAndView cancelBooking(@RequestParam("bookingId") int bookingId, @RequestParam("customerId") int customerId, RedirectAttributes redirectAttributes) {
//	    String url = BOOKING_SERVICE_URL + "/cancel/" + bookingId;
//	    try {
//	        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, null, String.class);
//	        redirectAttributes.addFlashAttribute("success", response.getBody());
//	    } catch (Exception e) {
//	        redirectAttributes.addFlashAttribute("error", "Error canceling booking: " + e.getMessage());
//	    }
//	    return new ModelAndView("redirect:/customerBookings?customerId=" + customerId);
//	}
	
	private static final String CUSTOMER_SERVICE_URL = "http://localhost:9092/api/customers"; 

//	@GetMapping("/profile")
//    public String showProfilePage(@RequestParam(required = false) String email, Model model) {
//        if (email != null && !email.isEmpty()) {
//            try {
//                CustomerModel customer = restTemplate.getForObject(CUSTOMER_SERVICE_URL + "/get/{email}", CustomerModel.class, email);
//
//                if (customer != null) {
//                    model.addAttribute("customerName", customer.getName());
//                    model.addAttribute("customerEmail", customer.getEmail());
//                    model.addAttribute("customerPhone", customer.getPhone());
//                } else {
//                    model.addAttribute("error", "Customer not found.");
//                }
//            } catch (Exception e) {
//                model.addAttribute("error", "Error fetching profile data.");
//            }
//        }
//        return "profile";  

}

