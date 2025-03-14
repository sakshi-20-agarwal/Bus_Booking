package com.sprint.btb.service;

import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.TripModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TripService {

	public List<TripModel> getAllTrips() throws BadRequestException;

	TripModel getTripById(int tripId) throws BadRequestException;
	public List<TripModel> getTripsByFromCity(String fromCity) throws BadRequestException;
	public List<TripModel> getTripsByToCity(String toCity) throws BadRequestException;
	public List<TripModel> getTripsByFromCityToCityAndDate(String fromCity, String toCity, LocalDateTime tripDate)
			throws BadRequestException;
	public List<Integer> getAvailableSeats(int tripId) throws BadRequestException;
	// Fetch trips by "from city", "to city", "trip date", and "bus type"
	// List<TripModel> fetchTripsByFromCityToCityDateAndBusType(String fromCity,
	// String toCity, LocalDateTime tripDate, String busType) throws
	// BadRequestException;

}
