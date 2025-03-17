package com.sprint.btb.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import com.sprint.btb.model.BusModel;
import com.sprint.btb.model.TripBusModel;

@Controller
@RequestMapping("/user")
public class BusListUIController {

	 private final RestTemplate restTemplate;

	    public BusListUIController(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }

	    @GetMapping("/buses")
	    public ModelAndView getTrips() {
	        ModelAndView modelAndView = new ModelAndView("buslist"); // Set Thymeleaf view name
	        
	        // Fetch trips from Trip Service
	        String tripUrl = "http://localhost:9093/api/trips/";
	        TripBusModel[] tripBusArray = restTemplate.getForObject(tripUrl, TripBusModel[].class);
	        List<TripBusModel> trips = Arrays.asList(tripBusArray);

	        // Fetch bus details for each trip
	        for (TripBusModel trip : trips) {
	            if (trip.getBus() != null && trip.getBus().getBusId() > 0) {
	                try {
	                    // Fetch bus details from Bus Service using busId
	                    String busUrl = "http://localhost:9093/api/buses/id/" + trip.getBus().getBusId();
	                    BusModel bus = restTemplate.getForObject(busUrl, BusModel.class);
	                    
	                    // Set bus details in TripBusModel
	                    if (bus != null) {
	                        trip.setBusName(bus.getBusName());
	                        trip.setBusType(bus.getBusType().toString());
	                    }
	                } catch (Exception e) {
	                    System.err.println("Error fetching bus details for bus ID: " + trip.getBus().getBusId());
	                }
	            }
	        }

	        // Add trips to ModelAndView
	        modelAndView.addObject("trips", trips);
	        return modelAndView;
	    }
//	    @GetMapping("/buses")
//	    public String getTrips(Model model) {
//	        // Fetch trips from Trip Service
//	        String tripUrl = "http://localhost:9093/api/trips/";
//	        TripBusModel[] tripBusArray = restTemplate.getForObject(tripUrl, TripBusModel[].class);
//	        List<TripBusModel> trips = Arrays.asList(tripBusArray);
//
//	        // Fetch bus details for each trip
//	        for (TripBusModel trip : trips) {
//	            if (trip.getBus() != null && trip.getBus().getBusId() > 0) {
//	                try {
//	                    // Fetch bus details from Bus Service using busId
//	                    String busUrl = "http://localhost:9093/api/buses/id/" + trip.getBus().getBusId();
//	                    BusModel bus = restTemplate.getForObject(busUrl, BusModel.class);
//	                    
//	                    // Set bus details in TripBusModel
//	                    if (bus != null) {
//	                        trip.setBusName(bus.getBusName());
//	                        trip.setBusType(bus.getBusType().toString());
//	                    }
//	                } catch (Exception e) {
//	                    System.err.println("Error fetching bus details for bus ID: " + trip.getBus().getBusId());
//	                }
//	            }
//	        }
//
//	        // Add trips to model
//	        model.addAttribute("trips", trips);
//	        return "buslist"; // Redirect to Thymeleaf HTML page
//	    }
	    /*@GetMapping("/buses")
	    public String getTrips(Model model) {
	        // Replace with the actual Trip Service URL
	        String url = "http://localhost:9093/api/trips/";

	        // Fetch trips from Trip Service
	        TripBusModel[] tripBusArray = restTemplate.getForObject(url, TripBusModel[].class);

	        // Convert array to list
	        List<TripBusModel> trips = Arrays.asList(tripBusArray);
	        
	        for (TripBusModel trip : trips) {
	            String busUrl = "http://localhost:9093/api/buses/" + trip.getBus(); // Assuming busId is available
	            BusModel bus = restTemplate.getForObject(busUrl, BusModel.class);
	            if (bus != null) {
	                trip.setBusName(bus.getBusName());
	                trip.setBusType(bus.getBusType().toString());
	            }
	        }


	        // Add trips to model
	        model.addAttribute("trips", trips);

	        return "buslist"; // Redirect to Thymeleaf HTML page
	    }*/
}
