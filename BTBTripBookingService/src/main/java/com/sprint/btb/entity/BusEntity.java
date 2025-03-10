package com.sprint.btb.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="buses")
public class BusEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int busId;
 
	@Column(name = "registration_number", nullable = false, length = 20)
	private String registrationNumber;
	
	@Column(nullable = false)
	private Integer capacity;
	
	@Column(name="type",nullable = false, length = 30)
	private BusType bustype;
	
	public enum BusType {
		AC,
	    NONAC 
	}
 

	public BusEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BusEntity(int busId, String registrationNumber, Integer capacity, BusType bustype) {
		super();
		this.busId = busId;
		this.registrationNumber = registrationNumber;
		this.capacity = capacity;
		this.bustype = bustype;
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


	public Integer getCapacity() {
		return capacity;
	}


	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}


	public BusType getBustype() {
		return bustype;
	}


	public void setBustype(BusType bustype) {
		this.bustype = bustype;
	}


	@Override
	public String toString() {
		return "BusEntity [busId=" + busId + ", registrationNumber=" + registrationNumber + ", capacity=" + capacity
				+ ", bustype=" + bustype + "]";
	}

	
 
}
