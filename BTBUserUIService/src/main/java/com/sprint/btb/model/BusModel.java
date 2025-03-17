package com.sprint.btb.model;

public class BusModel {
	private int busId;
	private String busName;
	private String registrationNumber;
	private Integer capacity;
	private BusType busType;

	public BusModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusModel(int busId, String busName, String registrationNumber, Integer capacity, BusType busType) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.registrationNumber = registrationNumber;
		this.capacity = capacity;
		this.busType = busType;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public BusType getBusType() {
		return busType;
	}

	public void setBusType(BusType busType) {
		this.busType = busType;
	}

	@Override
	public String toString() {
		return "BusModel [busId=" + busId + ", busName=" + busName + ", registrationNumber=" + registrationNumber
				+ ", capacity=" + capacity + ", busType=" + busType + "]";
	}
}
