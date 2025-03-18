package com.sprint.btb.model;
 
import java.time.LocalDateTime;
 
public class TicketDetailsModel {
    private int bookingId;
    private String customerName;
    private int seatNumber;
    private String busName;
    private String fromCity;
    private String toCity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private float fare;
 
    public TicketDetailsModel() {
    }
 
    public TicketDetailsModel(int bookingId, String customerName, int seatNumber, String busName,
                              String fromCity, String toCity, LocalDateTime departureTime,
                              LocalDateTime arrivalTime, float fare) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
        this.busName = busName;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.fare = fare;
    }
 
    // Getters and Setters
    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }
 
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
 
    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }
 
    public String getBusName() { return busName; }
    public void setBusName(String busName) { this.busName = busName; }
 
    public String getFromCity() { return fromCity; }
    public void setFromCity(String fromCity) { this.fromCity = fromCity; }
 
    public String getToCity() { return toCity; }
    public void setToCity(String toCity) { this.toCity = toCity; }
 
    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }
 
    public LocalDateTime getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(LocalDateTime arrivalTime) { this.arrivalTime = arrivalTime; }
 
    public float getFare() { return fare; }
    public void setFare(float fare) { this.fare = fare; }
}