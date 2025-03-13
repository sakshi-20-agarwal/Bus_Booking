package com.sprint.btb.model;

public class BookingModel {
	private int bookingId;
    private int tripId;
    private int seatNumber;
    private String status;
	public BookingModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingModel(int bookingId, int tripId, int seatNumber, String status) {
		super();
		this.bookingId = bookingId;
		this.tripId = tripId;
		this.seatNumber = seatNumber;
		this.status = status;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BookingDTO [bookingId=" + bookingId + ", tripId=" + tripId + ", seatNumber=" + seatNumber + ", status="
				+ status + "]";
	}
    
    
}
