package com.sprint.btb.ctrl;

import com.sprint.btb.model.AddressModel;
import com.sprint.btb.service.BoardingDroppingPointsUIService;
import com.sprint.btb.exception.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardingDroppingController {

    private final BoardingDroppingPointsUIService uiService;

    @Autowired
    public BoardingDroppingController(BoardingDroppingPointsUIService uiService) {
        this.uiService = uiService;
    }

    // Load the boarding and dropping points page
    @GetMapping("/boardDrop")
    public ModelAndView getBoardingDroppingPage() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            // Fetch addresses for dropdowns
            List<AddressModel> addresses = uiService.fetchAddresses();
            modelAndView.addObject("addresses", addresses);  // Add attributes to the model
            modelAndView.setViewName("boardDrop");  // Set the view name (Thymeleaf template)
        } catch (BadRequestException e) {
            modelAndView.addObject("error", "Failed to fetch addresses.");  // Add error message to model
            modelAndView.setViewName("error");  // Set the view to error page
        }
        return modelAndView;
    }
    // Handle the form submission (redirect to payment page)
    @PostMapping("/proceed-to-payment")
    public String proceedToPayment(String boardingAddress, String droppingAddress, Model model) {
        // Simulate payment process (success or failure)
        boolean paymentSuccessful = Math.random() > 0.5;  // Randomly decide if payment is successful

        // Add attributes to model for payment status
        if (paymentSuccessful) {
            model.addAttribute("paymentStatus", "success");
            model.addAttribute("customerName", "John Doe");
            model.addAttribute("seatNumber", "A1");
            model.addAttribute("busDetails", "Bus ABC, Departure: 10:00 AM");
        } else {
            model.addAttribute("paymentStatus", "failure");
        }

        // Redirect to payment-status page
        return "paymentStatus";  // Payment status page
    }
}

