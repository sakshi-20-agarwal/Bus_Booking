package com.sprint.btb.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.btb.model.BookingModel;


@Service
public class BookingService {
	
    @Autowired
    private ApiService apiService;

    private final String BOOKING_SERVICE_URL = "http://localhost:9092/api/bookings";

    public Set<BookingModel> getAllBookings() {
        return apiService.getForObject(BOOKING_SERVICE_URL, Set.class);
    }

    public BookingModel createBooking(BookingModel booking) {
        return apiService.postForEntity(BOOKING_SERVICE_URL + "/create", booking, BookingModel.class).getBody();
    }
}