package com.sprint.btb.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint.btb.entity.*;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

	@Query("SELECT b FROM BookingEntity b WHERE b.trip.tripId = :tripId AND b.seatNumber = :seatNumber")
	Optional<BookingEntity> findByTripIdAndSeatNumber(@Param("tripId") int tripId, @Param("seatNumber") int seatNumber);

	// Find all bookings by trip ID
	@Query("SELECT b FROM BookingEntity b WHERE b.trip.tripId = :tripId")
	List<BookingEntity> findByTripId(@Param("tripId") int tripId);

	@Modifying
	@Query("UPDATE BookingEntity b SET b.status = :status WHERE b.trip.tripId = :tripId AND b.seatNumber = :seatNumber")
	void updateBookingStatus(@Param("tripId") int tripId, @Param("seatNumber") int seatNumber,
			@Param("status") BookingEntity.BookingStatus status);

	@Modifying
	@Query("UPDATE BookingEntity b SET b.status = :status WHERE b.bookingId = :bookingId")
	void updateBookingStatus(@Param("bookingId") int bookingId, @Param("status") BookingEntity.BookingStatus status);
    int countByTrip_Bus_BusIdAndStatus(int busId, BookingEntity.BookingStatus status);

}
