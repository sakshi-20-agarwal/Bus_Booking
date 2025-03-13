package com.sprint.btb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.sprint.btb.entity.ReviewEntity;
import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.ReviewModel;
import com.sprint.btb.model.TripModel;
import com.sprint.btb.repo.ReviewRepository;
import com.sprint.btb.util.ReviewUtil;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private RestTemplate restTemplate;
	private static final String TRIP_SERVICE_URL = "http://localhost:9005/api/trips";

	@Override
	public ReviewModel getReviewById(int reviewId) throws BadRequestException {
		try {
			ReviewEntity review = reviewRepository.findById(reviewId)
					.orElseThrow(() -> new BadRequestException("Review not found"));
			TripModel tripModel = restTemplate.getForObject(TRIP_SERVICE_URL + "/" + review.getTripId(),
					TripModel.class);
			if (tripModel == null) {
				throw new BadRequestException("Trip not found");
			}
			ReviewModel reviewModel = ReviewUtil.convertReviewEntityToEntityModel(review);
			return reviewModel;
		} catch (Exception e) {
			throw new BadRequestException("Error fetching review");
		}
	}

	@Override
	public ReviewModel addReview(ReviewEntity review) throws BadRequestException {
		try {
			ReviewEntity savedReview = reviewRepository.save(review);
			return ReviewUtil.convertReviewEntityToEntityModel(savedReview);
		} catch (Exception e) {
			throw new BadRequestException("Invalid review data");
		}
	}

	@Override
	public ReviewModel updateReview(int reviewId, ReviewModel reviewModel) throws BadRequestException {
		try {
			ReviewEntity existingReview = reviewRepository.findById(reviewId)
					.orElseThrow(() -> new BadRequestException("Review not found"));
			existingReview.setRating(reviewModel.getRating());
			existingReview.setComment(reviewModel.getComment());
			existingReview.setReviewDate(reviewModel.getReviewDate());
			ReviewEntity updatedReview = reviewRepository.save(existingReview);
			return ReviewUtil.convertReviewEntityToEntityModel(updatedReview);
		} catch (Exception e) {
			throw new BadRequestException("Error updating review");
		}
	}

	@Override
	public String deleteReview(int reviewId) throws BadRequestException {
		try {
			ReviewEntity review = reviewRepository.findById(reviewId)
					.orElseThrow(() -> new BadRequestException("Review not found"));
			reviewRepository.delete(review);
			return "Review with ID " + reviewId + " was successfully deleted.";
		} catch (Exception e) {
			throw new BadRequestException("Error deleting review: " + e.getMessage());
		}
	}

//	@Override
//	public ReviewModel getReviewsByCustomerId(int customerId) throws BadRequestException {
//
//		Optional<ReviewEntity> reviewEn = reviewRepository.findById(customerId);
//		if (reviewEn.isPresent()) {
//			return ReviewUtil.convertReviewEntityToEntityModel(reviewEn.get());
//		}
//		throw new BadRequestException("Review for Customer Id " + customerId + " Not Found!");
//	}

	@Override
	public List<ReviewModel> getReviewsByTripId(int tripId) throws BadRequestException {
		try {
			List<ReviewEntity> reviews = reviewRepository.findReviewByTripId(tripId);
			return reviews.stream().map(ReviewUtil::convertReviewEntityToEntityModel).collect(Collectors.toList());
		} catch (Exception e) {
			throw new BadRequestException("Error fetching reviews by trip ID");
		}
	}

	@Override
	public List<ReviewModel> getAllReviews() throws BadRequestException {
		try {
			List<ReviewEntity> reviews = reviewRepository.findAll();
			return reviews.stream().map(ReviewUtil::convertReviewEntityToEntityModel).collect(Collectors.toList());
		} catch (Exception e) {
			throw new BadRequestException("Error fetching all reviews");
		}
	}
}
