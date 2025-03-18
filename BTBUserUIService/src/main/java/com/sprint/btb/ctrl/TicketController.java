package com.sprint.btb.ctrl;

import com.sprint.btb.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/ticketdetails")
	public ModelAndView getTicketDetails(@RequestParam("bookingId") int bookingId) {
		System.out.println("Fetching booking");
		BookingModel booking = restTemplate.getForObject("http://localhost:9093/api/bookings/" + bookingId,
				BookingModel.class);
		System.out.println("Booking details for ID " + bookingId + ": " + booking);

		if (booking == null) {
			return new ModelAndView("ticketDetails", "errorMessage", "No booking found.");
		}

		TripModel trip = restTemplate.getForObject("http://localhost:9093/api/trips/" + booking.getTripId(),
				TripModel.class);

		if (trip == null) {
			return new ModelAndView("ticketDetails", "errorMessage", "Invalid Trip details");
		}

		RouteModel route = trip.getRoute();
		if (route == null) {
			return new ModelAndView("ticketDetails", "errorMessage", "Invalid Route details");
		}

		if (booking.getCustomerId() == null) {
			return new ModelAndView("ticketDetails", "errorMessage", "You don't have any bookings!");
		}

		CustomerModel customer = restTemplate
				.getForObject("http://localhost:9092/api/customers/" + booking.getCustomerId(), CustomerModel.class);
		System.out.println("Customer details for ID " + bookingId + ": " + customer);

		TicketDetailsModel ticketDetails = new TicketDetailsModel(booking.getBookingId(),
				customer != null ? customer.getName() : "Unknown", booking.getSeatNumber(), trip.getBus().getBusName(),
				route.getFromCity(), route.getToCity(), trip.getDepartureTime(), trip.getArrivalTime(), trip.getFare());

		System.out.println(ticketDetails);
		ModelAndView modelAndView = new ModelAndView("ticketDetails");
		modelAndView.addObject("ticket", ticketDetails);

		return modelAndView;
	}

}
