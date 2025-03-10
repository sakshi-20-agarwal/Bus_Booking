package com.sprint.btb.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class ReviewEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private Long reviewId;

	@Column(name = "customer_id")
	private CustomerEntity customer;

	@Column(name = "trip_id")
	private int tripId;

	@Column(name = "rating")
	private Integer rating;

	@Column(name = "comment")
	private String comment;

	@Column(name = "review_date")
	private Date reviewDate;

	public ReviewEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewEntity(Long reviewId, CustomerEntity customer, int tripId, Integer rating, String comment,
			Date reviewDate) {
		super();
		this.reviewId = reviewId;
		this.customer = customer;
		this.tripId = tripId;
		this.rating = rating;
		this.comment = comment;
		this.reviewDate = reviewDate;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Override
	public String toString() {
		return "ReviewEntity [reviewId=" + reviewId + ", customer=" + customer + ", rating=" + rating + ", comment="
				+ comment + ", reviewDate=" + reviewDate + "]";
	}

}
