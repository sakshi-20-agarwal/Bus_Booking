package com.sprint.btb.model;
 
public class TicketModel {
 
	private int bookingId;
	private Integer seatNumber;
	private BookingStatus status;
	private String busName;
	private String source;
	private String destination;
	private String departureTime;
	private String tripDate;
	private float fare;
 
	public TicketModel(int bookingId, Integer seatNumber, BookingStatus status,
			String busName, String source, String destination,
			String departureTime, String tripDate, float fare) {
 
		this.bookingId = bookingId;
		this.seatNumber = seatNumber;
		this.status = status;
		this.busName = busName;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.tripDate = tripDate;
		this.fare = fare;
	}
 
	// Getters and Setters
 
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
 
	public BookingStatus getStatus() {
		return status;
	}
 
	public void setStatus(BookingStatus status) {
		this.status = status;
	}
 
	public String getBusName() {
		return busName;
	}
 
	public void setBusName(String busName) {
		this.busName = busName;
	}
 
	public String getSource() {
		return source;
	}
 
	public void setSource(String source) {
		this.source = source;
	}
 
	public String getDestination() {
		return destination;
	}
 
	public void setDestination(String destination) {
		this.destination = destination;
	}
 
	public String getDepartureTime() {
		return departureTime;
	}
 
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
 
	public String getTripDate() {
		return tripDate;
	}
 
	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}
 
	public float getFare() {
		return fare;
	}
 
	public void setFare(float fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "TicketModel [bookingId=" + bookingId + ", seatNumber=" + seatNumber + ", status=" + status
				+ ", busName=" + busName + ", source=" + source + ", destination=" + destination + ", departureTime="
				+ departureTime + ", tripDate=" + tripDate + ", fare=" + fare + "]";
	}
	
}
 
 