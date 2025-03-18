package com.sprint.btb.model;

import java.time.LocalDateTime;

public class PaymentTicketModel {

	private int paymentId;
	private int customerId;
	private int tripId;
	private int seatNumber;
	private float amountPaid;
	private String paymentStatus;
	private String fromCity;
	private String toCity;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private float fare;
	private String busName;
	private String busType;
	

	public PaymentTicketModel() {

		super();

	}

	public PaymentTicketModel(int paymentId, int customerId, int tripId, int seatNumber, float amountPaid,

			String paymentStatus, String fromCity, String toCity, LocalDateTime departureTime,

			LocalDateTime arrivalTime, float fare, String busName, String busType) {

		this.paymentId = paymentId;

		this.customerId = customerId;

		this.tripId = tripId;

		this.seatNumber = seatNumber;

		this.amountPaid = amountPaid;

		this.paymentStatus = paymentStatus;

		this.fromCity = fromCity;

		this.toCity = toCity;

		this.departureTime = departureTime;

		this.arrivalTime = arrivalTime;

		this.fare = fare;

		this.busName = busName;

		this.busType = busType;

	}

	public int getPaymentId() {

		return paymentId;

	}

	public void setPaymentId(int paymentId) {

		this.paymentId = paymentId;

	}

	public int getCustomerId() {

		return customerId;

	}

	public void setCustomerId(int customerId) {

		this.customerId = customerId;

	}

	public int getTripId() {

		return tripId;

	}

	public void setTripId(int tripId) {

		this.tripId = tripId;

	}

	public int getSeatNumber() {

		return seatNumber;

	}

	public void setSeatNumber(int seatNumber) {

		this.seatNumber = seatNumber;

	}

	public float getAmountPaid() {

		return amountPaid;

	}

	public void setAmountPaid(float amountPaid) {

		this.amountPaid = amountPaid;

	}

	public String getPaymentStatus() {

		return paymentStatus;

	}

	public void setPaymentStatus(String paymentStatus) {

		this.paymentStatus = paymentStatus;

	}

	public String getFromCity() {

		return fromCity;

	}

	public void setFromCity(String fromCity) {

		this.fromCity = fromCity;

	}

	public String getToCity() {

		return toCity;

	}

	public void setToCity(String toCity) {

		this.toCity = toCity;

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

	@Override

	public String toString() {

		return "PaymentDetailsModel [paymentId=" + paymentId + ", customerId=" + customerId + ", tripId=" + tripId

				+ ", seatNumber=" + seatNumber + ", amountPaid=" + amountPaid + ", paymentStatus=" + paymentStatus

				+ ", fromCity=" + fromCity + ", toCity=" + toCity + ", departureTime=" + departureTime

				+ ", arrivalTime=" + arrivalTime + ", fare=" + fare + ", busName=" + busName + ", busType=" + busType

				+ "]";

	}

}
