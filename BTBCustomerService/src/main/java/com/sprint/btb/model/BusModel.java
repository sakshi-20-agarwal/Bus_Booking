package com.sprint.btb.model;

public class BusModel {
	private int busId;
    private String registrationNumber;
    private int capacity;
    private String type;
	public BusModel(int busId, String registrationNumber, int capacity, String type) {
		super();
		this.busId = busId;
		this.registrationNumber = registrationNumber;
		this.capacity = capacity;
		this.type = type;
	}
	public BusModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "BusDTO [busId=" + busId + ", registrationNumber=" + registrationNumber + ", capacity=" + capacity
				+ ", type=" + type + "]";
	}
    
    
}
