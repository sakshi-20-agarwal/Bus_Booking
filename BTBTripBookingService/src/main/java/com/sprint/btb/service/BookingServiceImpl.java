package com.sprint.btb.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.btb.entity.BookingEntity;
import com.sprint.btb.entity.TripEntity;
import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.BookingModel;
import com.sprint.btb.repo.BookingRepository;
import com.sprint.btb.repo.TripRepository;
import com.sprint.btb.util.BTBUtil;

import jakarta.transaction.Transactional;

@Service
@Transactional	
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingRepository bookingRepo;
	
	@Autowired
	TripRepository tripRepo;

	@Override
	public BookingModel createBooking(BookingModel bookingModel) throws BadRequestException {
		Optional<TripEntity> optionalTrip = tripRepo.findById(bookingModel.getTripId());

	    if (optionalTrip.isEmpty()) {
	        throw new BadRequestException("Trip not found with ID: " + bookingModel.getTripId() + ". It may have been deleted.");
	    }

	    // Check if the seat is already booked
	    Optional<BookingEntity> existingBooking = bookingRepo.findByTripIdAndSeatNumber(
	        bookingModel.getTripId(), bookingModel.getSeatNumber()
	    );

	    if (existingBooking.isPresent()) {
	        BookingEntity bookedSeat = existingBooking.get();
	        if (bookedSeat.getStatus() == BookingEntity.BookingStatus.Booked) {
	            throw new BadRequestException("Seat " + bookingModel.getSeatNumber() + " is already booked for this trip.");
	        }
	        bookedSeat.setStatus(BookingEntity.BookingStatus.Booked);
	        
	        // Update instead of creating new
	        BookingEntity updatedBooking = bookingRepo.save(bookedSeat); 
	        return BTBUtil.convertBookingEntityToModel(updatedBooking);
		    
	    }
	    throw new BadRequestException("No existing booking found for Trip ID: " + bookingModel.getTripId() + " and Seat Number: " + bookingModel.getSeatNumber());	
	}
	//-----------------------------------------------------------------------------------------
	@Override
	public Set<BookingModel> getAllBookings() {
		List<BookingEntity> bookings = bookingRepo.findAll();
		return BTBUtil.convertBookingEntityListToModelSet(bookings);

	}
	
	//-----------------------------------------------------------------------------------------
	
	@Override
	public BookingModel getBookingById(int id) throws BadRequestException {
		Optional<BookingEntity> bookingEntity = bookingRepo.findById(id);
        if (bookingEntity.isPresent()) {
            return BTBUtil.convertBookingEntityToModel(bookingEntity.get());
        }
        throw new BadRequestException("Booking not Found with Id: " + id);
		
	}

	//-----------------------------------------------------------------------------------------
	
	@Override
	public Set<BookingModel> getBookingByTripId(int tripId) throws BadRequestException {
		 List<BookingEntity> bookingList = bookingRepo.findByTripId(tripId);
	     if (bookingList.isEmpty()) {
	         throw new BadRequestException("No bookings found for Trip Id: " + tripId);
	     }

		return BTBUtil.convertBookingEntityListToModelSet(bookingList);
		
	}

	//-----------------------------------------------------------------------------------------
	
	@Override
	public String cancelBooking(int bookingId) throws BadRequestException {
		Optional<BookingEntity> optionalBooking = bookingRepo.findById(bookingId);

	    if (optionalBooking.isEmpty()) {
	        throw new BadRequestException("Booking not found with ID: " + bookingId);
	    }

	    BookingEntity bookingEntity = optionalBooking.get();

	    // If the seat is already available, no need to cancel
	    if (bookingEntity.getStatus() == BookingEntity.BookingStatus.Available) {
	        return "Booking is already canceled.";
	    }

	    // Update the status to Available
	    bookingEntity.setStatus(BookingEntity.BookingStatus.Available);
	    bookingRepo.save(bookingEntity);  

	    return "Booking ID " + bookingId + " has been successfully canceled.";
	}

	//-----------------------------------------------------------------------------------------
	
	@Override
	public BookingModel updateBooking(int bookingId, BookingModel updatedBooking) throws BadRequestException {
	    Optional<BookingEntity> optionalBooking = bookingRepo.findById(bookingId);

	    if (optionalBooking.isEmpty()) {
	        throw new BadRequestException("Booking not found with ID: " + bookingId);
	    }

	    BookingEntity existingBooking = optionalBooking.get();

	    // Fetch trip ID from the associated TripEntity
	    Integer tripId = (existingBooking.getTrip() != null) ? existingBooking.getTrip().getTripId() : null;

	    if (tripId == null) {
	        throw new BadRequestException("Trip ID is missing for booking ID: " + bookingId);
	    }

	    // Ensure seat number is being updated and check if the new seat is already booked
	    if (updatedBooking.getSeatNumber() != null && !updatedBooking.getSeatNumber().equals(existingBooking.getSeatNumber())) {
	        Optional<BookingEntity> existingSeatBooking = bookingRepo.findByTripIdAndSeatNumber(tripId, updatedBooking.getSeatNumber());
	        if (existingSeatBooking.isPresent()) {
	            BookingEntity seatBooking = existingSeatBooking.get();
	            // Prevent booking the same seat if it's already booked by someone else
	            if (seatBooking.getStatus() == BookingEntity.BookingStatus.Booked) {
	                throw new BadRequestException("Seat " + updatedBooking.getSeatNumber() + " is already booked for this trip.");
	            }
	        }

	        // If seat is available, update seat number
	        existingBooking.setSeatNumber(updatedBooking.getSeatNumber());
	    }

	    // Update booking status if provided
	    if (updatedBooking.getStatus() != null) {
	        existingBooking.setStatus(updatedBooking.getStatus());
	    }

	    // Save updated booking
	    BookingEntity savedBooking = bookingRepo.save(existingBooking);
	    return BTBUtil.convertBookingEntityToModel(savedBooking);
	}


	//-----------------------------------------------------------------------------------------
	@Override
	public BookingModel getBookingByTripAndSeatNumber(int tripId, Integer seatNumber) throws BadRequestException {
		 Optional<BookingEntity> optionalBooking = bookingRepo.findByTripIdAndSeatNumber(tripId, seatNumber);

		if (optionalBooking.isPresent()) {
				return BTBUtil.convertBookingEntityToModel(optionalBooking.get());
			}
			throw new BadRequestException("No booking found for trip ID: " + tripId + " and seat number: " + seatNumber);
	}
	
	
	
}
