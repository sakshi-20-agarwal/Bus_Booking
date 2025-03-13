package com.sprint.btb.model;

import java.time.LocalDateTime;

public class ReviewModel {
	private int reviewId;
	private int customerId;
	private int tripId;
	private int rating;
	private String comment;
	private LocalDateTime reviewDate;

	public ReviewModel(int reviewId, int customerId, int tripId, int rating, String comment, LocalDateTime reviewDate) {
		super();
		this.reviewId = reviewId;
		this.customerId = customerId;
		this.tripId = tripId;
		this.rating = rating;
		this.comment = comment;
		this.reviewDate = reviewDate;
	}

	public ReviewModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(LocalDateTime reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Override
	public String toString() {
		return "ReviewDTO [reviewId=" + reviewId + ", customerId=" + customerId + ", tripId=" + tripId + ", rating="
				+ rating + ", comment=" + comment + ", reviewDate=" + reviewDate + "]";
	}

}
