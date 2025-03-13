package com.sprint.btb.model;

public class AddressModel {
	private int addressId;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    
    
    public AddressModel(int addressId, String address, String city, String state, String zipCode) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

    
	public AddressModel() {
		super();
		// TODO Auto-generated constructor stub
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
		return "AddressModel [addressId=" + addressId + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + "]";
	}
    
    
}
