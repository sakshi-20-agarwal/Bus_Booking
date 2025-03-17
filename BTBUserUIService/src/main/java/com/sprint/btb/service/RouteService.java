package com.sprint.btb.service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sprint.btb.model.RouteModel;


import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteService {

    private static final String ROUTE_SERVICE_URL = "http://localhost:9093/api/routes/";

    @Autowired
    private RestTemplate restTemplate;

    // Method to fetch all routes
    public List<RouteModel> getAllRoutes() {
        // Fetch the response as a List of RouteModel objects
        ResponseEntity<List<RouteModel>> response = restTemplate.exchange(
            ROUTE_SERVICE_URL, 
            HttpMethod.GET, 
            null, 
            new ParameterizedTypeReference<List<RouteModel>>() {}
        );

        // Return the deserialized list of RouteModel objects
        return response.getBody();
    }

    // Method to fetch 'From' cities
    public List<String> getFromCities() {
        List<RouteModel> routes = getAllRoutes(); // Get all routes
        return routes.stream()
                     .map(RouteModel::getFromCity)
                     .distinct()
                     .collect(Collectors.toList());
    }

    // Method to fetch 'To' cities
    public List<String> getToCities() {
        List<RouteModel> routes = getAllRoutes(); // Get all routes
        return routes.stream()
                     .map(RouteModel::getToCity)
                     .distinct()
                     .collect(Collectors.toList());
    }
}
