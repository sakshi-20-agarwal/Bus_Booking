package com.sprint.btb.model;
 
import java.time.LocalDateTime;
 
public class TripBusModel {
 
	private int tripId;
	private int busId;
	private String busName;
	private String busType;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private float fare;
	
	private BusModel bus;
 
	public BusModel getBus() {
		return bus;
	}
 
	public void setBus(BusModel bus) {
		this.bus = bus;
        if (bus != null) {
            this.busId = bus.getBusId(); // Extract busId from BusModel
        }
	}
 
	public TripBusModel() {
		super();
	}
 
	public TripBusModel(int tripId, String busName, String busType, LocalDateTime departureTime,
			LocalDateTime arrivalTime, float fare) {
		this.tripId = tripId;
		this.busName = busName;
		this.busType = busType;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.fare = fare;
	}
 
 
	public int getBusId() {
		return busId;
	}
 
	public void setBusId(int busId) {
		this.busId = busId;
	}
	
	public int getTripId() {
		return tripId;
	}
 
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
 
	public String getBusName() {
		return busName;
	}
 
	public void setBusName(String busName) {
		this.busName = busName;
	}
 
	public String getBusType() {
		return busType;
	}
 
	public void setBusType(String busType) {
		this.busType = busType;
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
 
	public float getFare() {
		return fare;
	}
 
	public void setFare(float fare) {
		this.fare = fare;
	}
 
	@Override
	public String toString() {
		return "TripBusModel [tripId=" + tripId + ", busName=" + busName + ", busType=" + busType + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + ", fare=" + fare + "]";
	}
}