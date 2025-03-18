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
 
//    @GetMapping("/ticketdetails")
//    public ModelAndView getTicketDetails(@RequestParam("bookingId") int bookingId) {
//        // Fetch Booking Details
//    	System.out.println("Fetching booking");
//        BookingModel booking = restTemplate.getForObject(
//                "http://localhost:9093/api/bookings/" + bookingId, BookingModel.class);
//        System.out.println("Booking details for ID " + bookingId + ": " + booking);
//
//        if (booking == null || booking.getTripModel() == null || booking.getRouteModel() == null) {
//            return new ModelAndView("ticketDetails", "errorMessage", "Invalid Booking ID");
//        }
// 
//        // Fetch Customer Details
//        CustomerModel customer = restTemplate.getForObject(
//                "http://localhost:9092/api/customers/" + booking.getCustomerId(), CustomerModel.class);
//        System.out.println("Customer details for ID " + bookingId + ": " + customer);
//        TripModel trip = booking.getTripModel();
//        RouteModel route = booking.getRouteModel();
// 
//        // Create TicketDetailsModel
//        TicketDetailsModel ticketDetails = new TicketDetailsModel(
//                booking.getBookingId(),
//                customer != null ? customer.getName() : "Unknown",
//                booking.getSeatNumber(),
//                trip.getBus().getBusName(),
//                route.getFromCity(),
//                route.getToCity(),
//                trip.getDepartureTime(),
//                trip.getArrivalTime(),
//                trip.getFare()
//        );
//
//        System.out.println(ticketDetails);
//        // Pass TicketDetailsModel to Thymeleaf
//        ModelAndView modelAndView = new ModelAndView("ticketDetails");
//        modelAndView.addObject("ticket", ticketDetails);
//       
//        return modelAndView;
//    }
    
    @GetMapping("/ticketdetails")
    public ModelAndView getTicketDetails(@RequestParam("bookingId") int bookingId) {
        // Fetch Booking Details
        System.out.println("Fetching booking");
        BookingModel booking = restTemplate.getForObject(
                "http://localhost:9093/api/bookings/" + bookingId, BookingModel.class);
        System.out.println("Booking details for ID " + bookingId + ": " + booking);

        // Check if booking is null
        if (booking == null) {
            return new ModelAndView("ticketDetails", "errorMessage", "No booking found.");
        }

        // Fetch Trip and Route details
        TripModel trip = restTemplate.getForObject(
                "http://localhost:9093/api/trips/" + booking.getTripId(), TripModel.class);
        
        // Check if trip is null
        if (trip == null) {
            return new ModelAndView("ticketDetails", "errorMessage", "Invalid Trip details");
        }

        // Fetch Route details from the Trip
        RouteModel route = trip.getRoute();  // Route is already part of TripModel
        if (route == null) {
            return new ModelAndView("ticketDetails", "errorMessage", "Invalid Route details");
        }

        if (booking.getCustomerId() == null) {
            return new ModelAndView("ticketDetails", "errorMessage", "You don't have any bookings!");
        }

        // Fetch Customer Details
        CustomerModel customer = restTemplate.getForObject(
                "http://localhost:9092/api/customers/" + booking.getCustomerId(), CustomerModel.class);
        System.out.println("Customer details for ID " + bookingId + ": " + customer);
        
       
        // Create TicketDetailsModel
        TicketDetailsModel ticketDetails = new TicketDetailsModel(
                booking.getBookingId(),
                customer != null ? customer.getName() : "Unknown",
                booking.getSeatNumber(),
                trip.getBus().getBusName(),
                route.getFromCity(),
                route.getToCity(),
                trip.getDepartureTime(),
                trip.getArrivalTime(),
                trip.getFare()
        );

        System.out.println(ticketDetails);
        // Pass TicketDetailsModel to Thymeleaf
        ModelAndView modelAndView = new ModelAndView("ticketDetails");
        modelAndView.addObject("ticket", ticketDetails);
       
        return modelAndView;
    }

}
