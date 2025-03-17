package com.sprint.btb.model;

public class CustomerModel {
    private int customerId;
    private String name;
    private String email;
    private String phone;
    private int addressId;
    private String password;

    public CustomerModel(int customerId, String name, String email, String phone, int addressId,
                     String password) {
        super();
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.addressId = addressId;
        this.password = password;
    }

    public CustomerModel() {
        super();
        // Default constructor
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CustomerModel [customerId=" + customerId + ", name=" + name + ", email=" + email + ", phone=" + phone
                + ", addressId=" + addressId + ", password=" + password + "]";
    } 
}

