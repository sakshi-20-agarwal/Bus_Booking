package com.sprint.btb.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "name", nullable = false)
	private String custName;

	@Column(name = "email", nullable = false, unique = true)
	private String custEmail;

	@Column(name = "phone", nullable = false, unique = true)
	private String custPhone;

	@Column(name = "address_id")
	private Long addressId;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PaymentEntity> payments;

	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerEntity(int customerId, String custName, String custEmail, String custPhone, Long addressId,
			List<PaymentEntity> payments) {
		super();
		this.customerId = customerId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custPhone = custPhone;
		this.addressId = addressId;
		this.payments = payments;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public List<PaymentEntity> getPayments() {
		return payments;
	}

	public void setPayments(List<PaymentEntity> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "CustomerEntity [customerId=" + customerId + ", custName=" + custName + ", custEmail=" + custEmail
				+ ", custPhone=" + custPhone + ", addressId=" + addressId + ", payments=" + payments + "]";
	}

}
