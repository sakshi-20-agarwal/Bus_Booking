package com.sprint.btb.model;

import java.time.LocalDateTime;

public class TripModel {
	private int tripId;
	private RouteModel route;
	private BusModel bus;
	private int boardingId;
	private int droppingId;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private Integer availableSeats;
	private float fare;
	private LocalDateTime tripDate;

	public TripModel(int tripId, RouteModel route, BusModel bus, int boardingId, int droppingId,
			LocalDateTime departureTime, LocalDateTime arrivalTime, Integer availableSeats, float fare,
			LocalDateTime tripDate) {
		super();
		this.tripId = tripId;
		this.route = route;
		this.bus = bus;
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

	public RouteModel getRoute() {
		return route;
	}

	public void setRoute(RouteModel route) {
		this.route = route;
	}

	public BusModel getBus() {
		return bus;
	}

	public void setBus(BusModel bus) {
		this.bus = bus;
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
		return "TripModel [tripId=" + tripId + ", boardingId=" + boardingId + ", droppingId=" + droppingId
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", availableSeats="
				+ availableSeats + ", fare=" + fare + ", tripDate=" + tripDate + "]";
	}
}
