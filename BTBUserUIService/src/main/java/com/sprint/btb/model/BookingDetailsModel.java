package com.sprint.btb.model;

import java.time.LocalDateTime;

public class BookingDetailsModel {

	private int bookingId;
	private String fromCity;
	private String toCity;
	private LocalDateTime departureTime;
	private String busName;
	private boolean isPastBooking;

	public BookingDetailsModel() {
	}

	public BookingDetailsModel(int bookingId, String fromCity, String toCity, LocalDateTime departureTime,
			String busName,boolean isPastBooking) {
		super();
		this.bookingId = bookingId;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.departureTime = departureTime;
		this.busName = busName;
		this.isPastBooking = isPastBooking;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public boolean isPastBooking() {
		return isPastBooking;
	}

	public void setPastBooking(boolean isPastBooking) {
		this.isPastBooking = isPastBooking;
	}
	
	@Override
	public String toString() {
		return "BookingDetailsModel [bookingId=" + bookingId + ", fromCity=" + fromCity + ", toCity=" + toCity
				+ ", departureTime=" + departureTime + ", busName=" + busName + ", isPastBooking=" + isPastBooking + "]";
	}

}
