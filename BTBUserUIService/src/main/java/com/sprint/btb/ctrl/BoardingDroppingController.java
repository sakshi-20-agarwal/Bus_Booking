package com.sprint.btb.ctrl;

import com.sprint.btb.model.AddressModel;
import com.sprint.btb.model.BookingModel;
import com.sprint.btb.model.PaymentModel;
import com.sprint.btb.model.RouteModel;
import com.sprint.btb.model.CustomerModel;

import com.sprint.btb.model.TripModel;
import com.sprint.btb.service.BoardingDroppingPointsUIService;
import com.sprint.btb.exception.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardingDroppingController {

	
	   @Autowired
	    private RestTemplate restTemplate;

	    private final String PAYMENT_SERVICE_URL = "http://localhost:9092/api/payments";

    private final BoardingDroppingPointsUIService uiService;

    @Autowired
    public BoardingDroppingController(BoardingDroppingPointsUIService uiService) {
        this.uiService = uiService;
    }

    @GetMapping("/boardDrop")
    public ModelAndView getBoardingDroppingPage() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<AddressModel> addresses = uiService.fetchAddresses();
            modelAndView.addObject("addresses", addresses);  
            modelAndView.setViewName("boardDrop"); 
        } catch (BadRequestException e) {
            modelAndView.addObject("error", "Failed to fetch addresses.");  
            modelAndView.setViewName("error");  
        }
        return modelAndView;
    }
 
    
    @PostMapping("/proceed-to-payment")
    public ModelAndView proceedToPayment(@RequestParam String boardingAddress, 
                                          @RequestParam String droppingAddress) {
        boolean paymentSuccessful = Math.random() > 0.5; 
        
        ModelAndView modelAndView = new ModelAndView();

        if (paymentSuccessful) {
            modelAndView.addObject("paymentStatus", "success");
//            modelAndView.addObject("customerName", "Pranjal");
//            modelAndView.addObject("seatNumber", "A1");
//            modelAndView.addObject("busDetails", "Sangitam, Departure: 10:00 PM");
        } else {
            modelAndView.addObject("paymentStatus", "failure");
        }

        modelAndView.setViewName("paymentStatus");  
        
        return modelAndView;
    }
    
    @GetMapping("/ticket")
    public ModelAndView getTicket(@RequestParam ("bookingId")int bookingId) {
        BookingModel booking = restTemplate.getForObject(
            "http://localhost:9093/api/bookings/" + bookingId, BookingModel.class);
     
        if (booking == null || booking.getTripModel() == null || booking.getRouteModel() == null) {
            return new ModelAndView("paymentStatus", "paymentStatus", "failure");
        }
     
        TripModel trip = booking.getTripModel();
        RouteModel route = booking.getRouteModel();
        CustomerModel customer = restTemplate.getForObject(
            "http://localhost:9092/api/customers/" + booking.getCustomerId(), CustomerModel.class);
     
        boolean paymentSuccessful = Math.random() > 0.5;
        ModelAndView modelAndView = new ModelAndView("paymentStatus");
     
        if (paymentSuccessful) {
            modelAndView.addObject("paymentStatus", "success");
            modelAndView.addObject("customerName", customer != null ? customer.getName() : "Unknown");
            modelAndView.addObject("seatNumber", booking.getSeatNumber());
            modelAndView.addObject("busDetails", trip.getBus().getBusName() + ", Departure: " + trip.getDepartureTime());
            modelAndView.addObject("fromCity", route.getFromCity());
            modelAndView.addObject("toCity", route.getToCity());
        } else {
            modelAndView.addObject("paymentStatus", "failure");
        }
     
        return modelAndView;
    }
    
}

