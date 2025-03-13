package com.sprint.btb.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
public class PaymentModel {
	private int paymentId;
	private int bookingId;
	private int customerId;
	private float amount;
	private LocalDateTime paymentDate;
	private PaymentStatus paymentStatus;

	public PaymentModel(int paymentId, int bookingId, int customerId, float amount, LocalDateTime paymentDate,
			PaymentStatus paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
	}

	public PaymentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "PaymentDTO [paymentId=" + paymentId + ", bookingId=" + bookingId + ", customerId=" + customerId
				+ ", amount=" + amount + ", paymentDate=" + paymentDate + ", paymentStatus=" + paymentStatus + "]";
	}

}
