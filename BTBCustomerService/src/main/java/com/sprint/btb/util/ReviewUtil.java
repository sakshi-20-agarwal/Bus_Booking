package com.sprint.btb.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.sprint.btb.entity.CustomerEntity;
import com.sprint.btb.entity.ReviewEntity;
import com.sprint.btb.model.CustomerModel;
import com.sprint.btb.model.ReviewModel;

public class ReviewUtil {
	public static ReviewModel convertReviewEntityToEntityModel(ReviewEntity review) {
		ReviewModel reviewModel = new ReviewModel();
		reviewModel.setReviewId(review.getReviewId());
		reviewModel.setRating(review.getRating());
		reviewModel.setComment(review.getComment());
		reviewModel.setReviewDate(review.getReviewDate());
		reviewModel.setTripId(review.getTripId());

		if (review.getCustomer() != null) {
			reviewModel.setCustomerId(review.getCustomer().getCustomerId());
		}
		return reviewModel;
	}

	public static ReviewEntity convertReviewModelToReviewEntity(ReviewModel reviewModel) {
		ReviewEntity review = new ReviewEntity();
		review.setReviewId(reviewModel.getReviewId());
		review.setRating(reviewModel.getRating());
		review.setComment(reviewModel.getComment());
		review.setReviewDate(reviewModel.getReviewDate());
		review.setTripId(reviewModel.getTripId());
		return review;
	}

	public static Set<ReviewModel> convertEntityListToSet(List<ReviewEntity> reviews) {
		Set<ReviewModel> reviewModelSet = new HashSet<>();

		for (ReviewEntity reviewEntity : reviews) {
			ReviewModel reviewModel = convertReviewEntityToEntityModel(reviewEntity);
			reviewModelSet.add(reviewModel);
		}

		return reviewModelSet;
	}
}
