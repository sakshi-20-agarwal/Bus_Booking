package com.sprint.btb.model;

import com.sprint.btb.entity.BookingEntity.BookingStatus;

public class BookingModel {

	private int bookingId;
	private Integer seatNumber;
	private int tripId;

	private BookingStatus status;

	public BookingModel(int bookingId, Integer seatNumber, int tripId, BookingStatus status) {
		super();
		this.bookingId = bookingId;
		this.seatNumber = seatNumber;
		this.tripId = tripId;
		this.status = status;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookingModel [bookingId=" + bookingId + ", seatNumber=" + seatNumber + ", tripId=" + tripId
				+ ", status=" + status + "]";
	}
}
