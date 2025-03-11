package com.sprint.btb.service;

import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.TripModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TripService {

	// Fetch trip details by trip ID
	TripModel fetchTripById(int tripId) throws BadRequestException;

	// Fetch trips by the "from city"
	List<TripModel> fetchTripsByFromCity(String fromCity) throws BadRequestException;

	// Fetch trips by the "to city"
	List<TripModel> fetchTripsByToCity(String toCity) throws BadRequestException;

	// Fetch trips by "from city", "to city", and "trip date"
	List<TripModel> fetchTripsByFromCityToCityAndDate(String fromCity, String toCity, LocalDateTime tripDate)
			throws BadRequestException;

	// Fetch trips by "from city", "to city", "trip date", and "bus type"
	// List<TripModel> fetchTripsByFromCityToCityDateAndBusType(String fromCity,
	// String toCity, LocalDateTime tripDate, String busType) throws
	// BadRequestException;
}
