package com.sprint.btb.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sprint.btb.model.BookingDetailsModel;
import com.sprint.btb.model.BookingModel;
import com.sprint.btb.model.BusModel;
import com.sprint.btb.model.RouteModel;
import com.sprint.btb.model.TripModel;

import jakarta.ws.rs.HttpMethod;


@Service
public class BookingService {
	
    @Autowired
    private ApiService apiService;
    
    @Autowired
    private RestTemplate restTemplate; 

    private final String BOOKING_SERVICE_URL = "http://localhost:9093/api/bookings";
    private final String TRIP_SERVICE_URL = "http://localhost:9093/api/trips"; 
    private final String ROUTE_SERVICE_URL = "http://localhost:9093/api/routes"; 
    private final String BUS_SERVICE_URL = "http://localhost:9093/api/buses"; 

    public Set<BookingModel> getAllBookings() {
        return apiService.getForObject(BOOKING_SERVICE_URL, Set.class);
    }

    public BookingModel createBooking(BookingModel booking) {
        return apiService.postForEntity(BOOKING_SERVICE_URL + "/create", booking, BookingModel.class).getBody();
    }
    
   public Set<BookingDetailsModel> getBookingDetailsByCustomerId(int customerId) {
        String url = BOOKING_SERVICE_URL + "/customer/" + customerId;
        BookingModel[] bookingsArray = restTemplate.getForObject(url, BookingModel[].class);
        
        Set<BookingDetailsModel> bookingDetails = new HashSet<>();

        for (BookingModel booking : bookingsArray) {
            TripModel trip = restTemplate.getForObject(TRIP_SERVICE_URL + "/" + booking.getTripId(), TripModel.class);
        	RouteModel route = trip.getRoute();
            BusModel bus = trip.getBus(); 
            
            boolean isPastBooking = trip.getDepartureTime().isBefore(LocalDateTime.now());
            // Create BookingDetailsModel
            BookingDetailsModel bookingDetail = new BookingDetailsModel(
                booking.getBookingId(),
                route.getFromCity(),
                route.getToCity(),
                trip.getDepartureTime(),
                bus.getBusName(),
                isPastBooking
            );

            bookingDetails.add(bookingDetail);
        }

        return bookingDetails;
    }
//    
//    public Set<BookingModel> getBookingsByCustomerId(int customerId) {
//        String url = BOOKING_SERVICE_URL + "/customer/" + customerId;
//
//        BookingModel[] bookingsArray = restTemplate.getForObject(url, BookingModel[].class);
//
//        return new HashSet<>(Arrays.asList(bookingsArray));
//    }
    
}