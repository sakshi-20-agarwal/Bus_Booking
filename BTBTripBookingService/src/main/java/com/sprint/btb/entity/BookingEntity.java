package com.sprint.btb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
@Table(name="bookings")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="booking_id")
    private Long bookingId;
 
    @ManyToOne
    @JoinColumn(name = "trip_id")
    private TripEntity trip;
 
    @Column(name = "seat_number", nullable = false)
    private Integer seatNumber;
    
    @Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private BookingStatus status = BookingStatus.Available;

	public enum BookingStatus {
		Available,
	    Booked
	}

	public BookingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingEntity(Long bookingId, TripEntity trip, Integer seatNumber, BookingStatus status) {
		super();
		this.bookingId = bookingId;
		this.trip = trip;
		this.seatNumber = seatNumber;
		this.status = status;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public TripEntity getTrip() {
		return trip;
	}

	public void setTrip(TripEntity trip) {
		this.trip = trip;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookingEntity [bookingId=" + bookingId + ", trip=" + trip + ", seatNumber=" + seatNumber + ", status="
				+ status + "]";
	}
	
	
}



	