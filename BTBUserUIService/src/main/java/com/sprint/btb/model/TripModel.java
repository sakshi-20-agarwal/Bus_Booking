package com.sprint.btb.model;

import java.time.LocalDateTime;


public class TripModel {
	private int tripId;
	private int routeId;
	private int busId;
	private int boardingId;
	private int droppingId;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private Integer availableSeats;
	private float fare;
	private LocalDateTime tripDate;
	public TripModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TripModel(int tripId, int routeId, int busId, int boardingId, int droppingId,
			LocalDateTime departureTime, LocalDateTime arrivalTime, Integer availableSeats, float fare,
			LocalDateTime tripDate) {
		super();
		this.tripId = tripId;
		this.routeId = routeId;
		this.busId = busId;
		this.boardingId = boardingId;
		this.droppingId = droppingId;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.availableSeats = availableSeats;
		this.fare = fare;
		this.tripDate = tripDate;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public int getRoute() {
		return routeId;
	}
	public void setRoute(int routeId) {
		this.routeId = routeId;
	}
	public int getBus() {
		return busId;
	}
	public void setBus(int busId) {
		this.busId = busId;
	}
	public int getBoardingId() {
		return boardingId;
	}
	public void setBoardingId(int boardingId) {
		this.boardingId = boardingId;
	}
	public int getDroppingId() {
		return droppingId;
	}
	public void setDroppingId(int droppingId) {
		this.droppingId = droppingId;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Integer getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
	public float getFare() {
		return fare;
	}
	public void setFare(float fare) {
		this.fare = fare;
	}
	public LocalDateTime getTripDate() {
		return tripDate;
	}
	public void setTripDate(LocalDateTime tripDate) {
		this.tripDate = tripDate;
	}
	@Override
	public String toString() {
		return "TripModel [tripId=" + tripId + ", route=" + routeId + ", bus=" + busId + ", boardingId=" + boardingId
				+ ", droppingId=" + droppingId + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", availableSeats=" + availableSeats + ", fare=" + fare + ", tripDate=" + tripDate + "]";
	}
}
