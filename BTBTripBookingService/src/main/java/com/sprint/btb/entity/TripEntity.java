package com.sprint.btb.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "trips")
public class TripEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trip_id")
	private Long tripId;

	@ManyToOne
	@JoinColumn(name = "route_id", referencedColumnName = "route_id")
	private RouteEntity route;

	@ManyToOne
	@JoinColumn(name = "bus_id", referencedColumnName = "bus_id")
	private BusEntity bus;

	@Column(name = "boarding_address_id")
	private int boardingId;

	@Column(name = "dropping_address_id")
	private int droppingId;

	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private Integer availableSeats;
	private float fare;
	private LocalDateTime tripDate;

	public TripEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TripEntity(Long tripId, RouteEntity route, BusEntity bus, int boardingId, int droppingId,
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

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
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
		return "TripEntity [tripId=" + tripId + ", route=" + route + ", bus=" + bus + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", availableSeats=" + availableSeats + ", fare=" + fare
				+ ", tripDate=" + tripDate + "]";
	}

}
