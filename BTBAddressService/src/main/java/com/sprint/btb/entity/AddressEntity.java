package com.sprint.btb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AddressEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="address_id")
	    private int addressId;
	 
	    @Column(name = "address", nullable = false, length = 255)
	    private String address;
	    
	    @Column(name="city",nullable = false, length = 255)
	    private String city;
	    
	    @Column(name="state",nullable = false, length = 255)
	    private String state;
	    
	    @Column(name = "zip_code", nullable = false, length = 6)
	    private String zipCode;

		public AddressEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public AddressEntity(int addressId, String address, String city, String state, String zipCode) {
			super();
			this.addressId = addressId;
			this.address = address;
			this.city = city;
			this.state = state;
			this.zipCode = zipCode;
		}

		public int getAddressId() {
			return addressId;
		}

		public void setAddressId(int addressId) {
			this.addressId = addressId;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getZipCode() {
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}

		@Override
		public String toString() {
			return "AddressEntity [addressId=" + addressId + ", address=" + address + ", city=" + city + ", state="
					+ state + ", zipCode=" + zipCode + "]";
		}
	 
	
}

