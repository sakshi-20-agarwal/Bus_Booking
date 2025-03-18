package com.sprint.btb.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/seatbooking")
public class SeatSelectionController {

	@Autowired
	private RestTemplate restTemplate;

	private static final String TRIP_SERVICE_URL = "http://localhost:9093/api/trips/";
	private static final String BUS_SERVICE_URL = "http://localhost:9093/api/buses/";
	private static final String BOOKING_SERVICE_URL = "http://localhost:9093/api/bookings";

	@GetMapping("/{tripId}/{busId}")
	public ModelAndView showSeatSelection(@PathVariable int tripId, @PathVariable int busId, Model model,HttpSession session) {
//	        // Fetch available seats from Booking Service
//	        List<Integer> availableSeats = restTemplate.getForObject(TRIP_SERVICE_URL + "/{tripId}/available-seats", List.class, tripId);
//	        
//	        // Fetch bus capacity
//	        int busCapacity = restTemplate.getForObject(BUS_SERVICE_URL + "/{busId}/seats", Integer.class, busId);
//
//	        // Prepare seat status array
//	        String[] seatStatus = new String[busCapacity];
//	        for (int i = 0; i < busCapacity; i++) {
//	            seatStatus[i] = availableSeats.contains(i + 1) ? "available" : "booked";
//	        }
//
//	        model.addAttribute("tripId", tripId);
//	        model.addAttribute("busId", busId);
//	        model.addAttribute("seatStatus", seatStatus);
//	        model.addAttribute("busCapacity", busCapacity);
//
//	        return "seatbooking"; // Thymeleaf template

		ModelAndView modelAndView = new ModelAndView("seatbooking"); // Set Thymeleaf view

//		
//		// Retrieve customer details from session
//        Long customerId = (Long) session.getAttribute("customerId");
//        if (customerId != null) {
//            CustomerModel customer = customerService.getCustomerDetails(customerId); // Assuming customerService fetches customer details
//            modelAndView.addObject("customer", customer);  // Add customer details to the view
//        }
		
		
		
		
		
		
		
		
		List<Integer> availableSeats = restTemplate.getForObject(TRIP_SERVICE_URL + "/{tripId}/available-seats",
				List.class, tripId);

		int busCapacity = restTemplate.getForObject(BUS_SERVICE_URL + "/{busId}/seats", Integer.class, busId);

		// Prepare seat status array
		String[] seatStatus = new String[busCapacity];
		for (int i = 0; i < busCapacity; i++) {
			int seatNumber = i + 1;
			seatStatus[i] = (availableSeats != null && availableSeats.contains(seatNumber)) ? "available" : "booked";
		}
		modelAndView.addObject("tripId", tripId);
		modelAndView.addObject("busId", busId);
		modelAndView.addObject("seatStatus", seatStatus);
		modelAndView.addObject("busCapacity", busCapacity);

		return modelAndView;
	}
}
