package com.sprint.btb.model;

import java.time.LocalDateTime;

import com.sprint.btb.entity.BusEntity;
import com.sprint.btb.entity.RouteEntity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class TripModel {

	private int tripId;
	private RouteEntity route;
	private BusEntity bus;
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
	public TripModel(int tripId, RouteEntity route, BusEntity bus, int boardingId, int droppingId,
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
	public RouteEntity getRoute() {
		return route;
	}
	public void setRoute(RouteEntity route) {
		this.route = route;
	}
	public BusEntity getBus() {
		return bus;
	}
	public void setBus(BusEntity bus) {
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
		return "TripModel [tripId=" + tripId + ", route=" + route + ", bus=" + bus + ", boardingId=" + boardingId
				+ ", droppingId=" + droppingId + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", availableSeats=" + availableSeats + ", fare=" + fare + ", tripDate=" + tripDate + "]";
	}
	
	
	

}
