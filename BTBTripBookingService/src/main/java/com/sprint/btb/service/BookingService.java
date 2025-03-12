package com.sprint.btb.service;

import java.util.Set;

import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.BookingModel;

public interface BookingService {
	
    public BookingModel createBooking(BookingModel bookingModel) throws BadRequestException;
    public Set<BookingModel> getAllBookings();
	public BookingModel getBookingById(int id) throws BadRequestException;
	public Set<BookingModel>  getBookingByTripId(int tripId) throws BadRequestException;
	public String cancelBooking(int bookingId) throws BadRequestException;
	public BookingModel updateBooking(int bookingId, BookingModel bookingModel) throws BadRequestException;
	public BookingModel getBookingByTripAndSeatNumber(int tripId, Integer seatNumber) throws BadRequestException;
	//public Set<BookingModel> getBookingsByCustomerId(int customerId) throws BadRequestException;
	boolean isSeatAvailable(int tripId, int seatNumber);


}
