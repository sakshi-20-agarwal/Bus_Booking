package com.sprint.btb.ctrl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.sprint.btb.entity.ReviewEntity;
import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.ReviewModel;
import com.sprint.btb.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/{id}")
	public ReviewModel fetchReviewById(@PathVariable("id") int reviewId) throws BadRequestException {
		return reviewService.getReviewById(reviewId);
	}

	@PostMapping("/add")
	public ReviewModel writeReview(@RequestBody ReviewEntity reviewEntity) throws BadRequestException {
		return reviewService.addReview(reviewEntity);
	}

	@PutMapping("/update/{id}")
	public ReviewModel updateReviewById(@PathVariable("id") int id, @RequestBody ReviewModel reviewModel)
			throws BadRequestException {
		return reviewService.updateReview(id, reviewModel);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteReviewById(@PathVariable("id") int id) throws BadRequestException {
		return reviewService.deleteReview(id);
	}

//	@GetMapping("/customer/{customerId}")
//	public ReviewModel fetchReviewsByCustomerId(@PathVariable("customerId") int customerId) throws BadRequestException {
//		return reviewService.getReviewsByCustomerId(customerId);
//	}

	@GetMapping("/trip/{tripId}")
	public List<ReviewModel> fetchReviewsByTripId(@PathVariable("tripId") int tripId) throws BadRequestException {
		return reviewService.getReviewsByTripId(tripId);
	}

	@GetMapping("/")
	public List<ReviewModel> fetchAllReviews() throws BadRequestException {
		return reviewService.getAllReviews();
	}
}