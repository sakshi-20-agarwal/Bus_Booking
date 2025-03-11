package com.sprint.btb.ctrl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.BookingModel;
import com.sprint.btb.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	// http://localhost:9092/api/bookings
	@GetMapping
	public Set<BookingModel> fetchAllBookings() {
		return bookingService.getAllBookings();
	}

	// http://localhost:9092/api/bookings/88
	@GetMapping("/{id}")
	public BookingModel fetchBookingById(@PathVariable("id") int id) throws BadRequestException {
		return bookingService.getBookingById(id); 
	}

	// http://localhost:9092/api/bookings/trip/2
	@GetMapping("/trip/{tripId}")
	public Set<BookingModel> fetchBookingByTripId(@PathVariable("tripId") int tripId) throws BadRequestException {
		return bookingService.getBookingByTripId(tripId);
	}

	// http://localhost:9092/api/bookings/trip/2/seat/62
	@GetMapping("/trip/{tripId}/seat/{seatNumber}")
	public BookingModel fetchBookingByTripAndSeatNumber(@PathVariable int tripId, @PathVariable int seatNumber) throws BadRequestException {
		return bookingService.getBookingByTripAndSeatNumber(tripId, seatNumber);
	}

	// http://localhost:9092/api/bookings/create
	@PostMapping("/create")
	public BookingModel createBooking(@RequestBody BookingModel booking) throws BadRequestException {
		return bookingService.createBooking(booking);
	}

	// http://localhost:9092/api/bookings/cancel/89
	@PutMapping("/cancel/{bookingId}")
	public String cancelBooking(@PathVariable int bookingId) throws BadRequestException {
		return bookingService.cancelBooking(bookingId);
	}

	// http://localhost:9092/api/bookings/update/89
	@PutMapping("/update/{bookingId}")
	public BookingModel updateBooking(@PathVariable int bookingId, @RequestBody BookingModel updatedBooking) throws BadRequestException {
		return bookingService.updateBooking(bookingId, updatedBooking);
	}

}
