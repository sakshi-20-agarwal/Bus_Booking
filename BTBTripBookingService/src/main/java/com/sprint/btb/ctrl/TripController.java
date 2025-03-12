package com.sprint.btb.ctrl;

import com.sprint.btb.model.TripModel;
import com.sprint.btb.repo.BookingRepository;
import com.sprint.btb.repo.TripRepository;
import com.sprint.btb.service.TripService;
import com.sprint.btb.entity.TripEntity;
import com.sprint.btb.exception.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {

	private final TripService tripService;

	@Autowired
	public TripController(TripService tripService) {
		this.tripService = tripService;
	}

//--------------------------------Get trip by trip ID--------------------------------------------------------//
	@GetMapping("/{tripId}")
	public TripModel getTripById(@PathVariable int tripId) throws BadRequestException {
		TripModel trip = tripService.fetchTripById(tripId);
		if (trip == null) {
			throw new BadRequestException("Trip with ID " + tripId + " not found.");
		}
		return trip;
	}

//------------------------------- Get trips by "from city"----------------------------------------------------//

	@GetMapping("/from/{fromCity}")
	public List<TripModel> getTripsByFromCity(@PathVariable String fromCity) throws BadRequestException {
		List<TripModel> trips = tripService.fetchTripsByFromCity(fromCity);
		if (trips == null || trips.isEmpty()) {
			throw new BadRequestException("No trips found from " + fromCity);
		}
		return trips;
	}

// --------------------------------Get trips by "to city"------------------------------------------------------//

	@GetMapping("/to/{toCity}")
	public List<TripModel> getTripsByToCity(@PathVariable String toCity) throws BadRequestException {
		List<TripModel> trips = tripService.fetchTripsByToCity(toCity);
		if (trips == null || trips.isEmpty()) {
			throw new BadRequestException("No trips found to " + toCity);
		}
		return trips;
	}

//------------------------------Get trips by "from city", "to city", and "trip date"-----------------------------//

	@GetMapping("/from/{fromCity}/to/{toCity}/on/{tripDate}")
	public List<TripModel> getTripsByFromCityToCityAndDate(@PathVariable String fromCity, @PathVariable String toCity,
			@PathVariable String tripDate) {

		System.out.println("Received tripDate: " + tripDate);

		try {
			// Define the correct DateTimeFormatter for ISO_LOCAL_DATE_TIME format
			DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

			// Parse the date using the formatter
			LocalDateTime date = LocalDateTime.parse(tripDate, formatter);
			System.out.println("Parsed date: " + date);

			// Call the service method after parsing the date
			List<TripModel> trips = tripService.fetchTripsByFromCityToCityAndDate(fromCity, toCity, date);
			return trips;

		} catch (Exception e) {
			// Log detailed error for debugging
			System.out.println("Failed to parse tripDate: " + tripDate);
			throw new IllegalArgumentException("Invalid date format. Expected format: yyyy-MM-dd'T'HH:mm:ss");
		}
	}

//-----------------------Get trips by "from city", "to city", "trip date", and "bus type"----------------------------//

//    @GetMapping("/from/{fromCity}/to/{toCity}/on/{tripDate}/bus/{busType}")
//    public List<TripModel> getTripsByFromCityToCityDateAndBusType(
//            @PathVariable String fromCity,
//            @PathVariable String toCity,
//            @PathVariable String tripDate,
//            @PathVariable String busType) {
//
//        try {
//            LocalDateTime date = LocalDateTime.parse(tripDate.replace("T", " ")); // Handle trip date format
//            List<TripModel> trips = tripService.fetchTripsByFromCityToCityDateAndBusType(fromCity, toCity, date, busType);
//            if (trips == null || trips.isEmpty()) {
//                throw new TripNotFoundException("No trips found for " + fromCity + " to " + toCity + " on " + tripDate + " with bus type " + busType);
//            }
//            return trips;
//        } catch (Exception e) {
//            throw new TripNotFoundException("Invalid date format or other error");
//        }
//    }

	@GetMapping("/{tripId}/available-seats")
	public List<Integer> getAvailableSeats(@PathVariable int tripId) throws BadRequestException {
		return tripService.getAvailableSeats(tripId);
	}

}
