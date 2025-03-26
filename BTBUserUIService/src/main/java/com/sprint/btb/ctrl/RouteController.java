package com.sprint.btb.ctrl;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sprint.btb.model.CustomerModel;
import com.sprint.btb.model.RouteModel;
import com.sprint.btb.service.CustomerService;
import com.sprint.btb.service.RouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {

    @Autowired
    private CustomerService customerservice;
    
 
    @Autowired
    private RouteService routeService;
    
//    @GetMapping("/index")
//    public String showIndexPage(Model model) {
//        // Pass the list of RouteModel objects to the template
//        List<RouteModel> routes = routeService.getAllRoutes();
//        model.addAttribute("routes", routes);  // Ensure this is a list of RouteModel
//        return "index";  // Ensure this corresponds to templates/index.html
//    }
    

    @GetMapping("/home")
    public String showHomePage(Model model) {
        // Pass the list of RouteModel objects to the template
        List<RouteModel> routes = routeService.getAllRoutes();
        model.addAttribute("routes", routes);  // Ensure this is a list of RouteModel
        return "home";  // Ensure this corresponds to templates/home.html
    }
    
    
    @PostMapping("/searchBuses")
    public String searchBuses(@RequestParam String fromLocation, @RequestParam String toLocation, Model model) {
        // Check if the user is logged in (replace with your actual login check)
        boolean userLoggedIn = false;  // Change this to your actual check for user login status

        if (!userLoggedIn) {
            // If the user is not logged in, add the message to the model
            model.addAttribute("message", "Please login or register to continue.");
            // Return to the home page where the message will be displayed
            return "home";
        }

        // Logic for searching buses can go here if the user is logged in
        // Example:
        // model.addAttribute("buses", busService.searchBuses(fromLocation, toLocation));

        // Redirect to the bus results page if logged in
        return "busResults";  // Change to your actual bus search results page
    }
   
   

}

	

