package com.sprint.btb.model;

import java.time.LocalDateTime;

public class TripModel {
	private int tripId;
    private RouteModel route;
    private BusModel bus;
    private int boardingAddressId;
    private int droppingAddressId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int availableSeats;
    private double fare;
    private LocalDateTime tripDate;
	public TripModel(int tripId, RouteModel route, BusModel bus, int boardingAddressId, int droppingAddressId,
			LocalDateTime departureTime, LocalDateTime arrivalTime, int availableSeats, double fare,
			LocalDateTime tripDate) {
		super();
		this.tripId = tripId;
		this.route = route;
		this.bus = bus;
		this.boardingAddressId = boardingAddressId;
		this.droppingAddressId = droppingAddressId;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.availableSeats = availableSeats;
		this.fare = fare;
		this.tripDate = tripDate;
	}
	public TripModel() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getBoardingAddressId() {
		return boardingAddressId;
	}
	public void setBoardingAddressId(int boardingAddressId) {
		this.boardingAddressId = boardingAddressId;
	}
	public int getDroppingAddressId() {
		return droppingAddressId;
	}
	public void setDroppingAddressId(int droppingAddressId) {
		this.droppingAddressId = droppingAddressId;
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
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
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
		return "TripDTO [tripId=" + tripId + ", route=" + route + ", bus=" + bus + ", boardingAddressId="
				+ boardingAddressId + ", droppingAddressId=" + droppingAddressId + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", availableSeats=" + availableSeats + ", fare=" + fare
				+ ", tripDate=" + tripDate + "]";
	}
    
    
}
