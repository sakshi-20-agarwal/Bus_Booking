package com.sprint.btb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "buses")
public class BusEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bus_id")
	private int busId;

	@Column(name = "bus_name")
	private String busName;

	@Column(name = "registration_number", nullable = false, length = 20)
	private String registrationNumber;

	@Column(nullable = false)
	private Integer capacity;

	@Enumerated(EnumType.STRING)
	@Column(name = "bus_type", nullable = false, length = 30)
	private BusType busType;

	public enum BusType {
		Ac, NonAc
	}

	public BusEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusEntity(int busId, String busName, String registrationNumber, Integer capacity, BusType busType) {
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

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	@Override
	public String toString() {
		return "BusEntity [busId=" + busId + ", busName=" + busName + ", registrationNumber=" + registrationNumber
				+ ", capacity=" + capacity + ", busType=" + busType + "]";
	}

}
