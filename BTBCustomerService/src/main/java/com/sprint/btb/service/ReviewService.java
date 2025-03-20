package com.sprint.btb.service;

import java.util.List;

import com.sprint.btb.entity.ReviewEntity;
import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.ReviewModel;

public interface ReviewService {
	ReviewModel getReviewById(int reviewId) throws BadRequestException;

	ReviewModel updateReview(int reviewId, ReviewModel reviewModel) throws BadRequestException;

	String deleteReview(int reviewId) throws BadRequestException;

//	ReviewModel getReviewsByCustomerId(int customerId) throws BadRequestException;

	List<ReviewModel> getReviewsByTripId(int tripId) throws BadRequestException;

	List<ReviewModel> getAllReviews() throws BadRequestException;

	List<ReviewModel> getReviewsByCustomerId(int customerId) throws BadRequestException;

	ReviewModel addReview(ReviewModel reviewModel) throws BadRequestException;
}
