package com.sprint.btb.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import com.sprint.btb.entity.CustomerEntity;
import com.sprint.btb.entity.ReviewEntity;
import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.ReviewModel;
import com.sprint.btb.repo.CustomerRepository;

public class ReviewUtil {

    // Convert ReviewEntity to ReviewModel
    public static ReviewModel convertReviewEntityToReviewModel(ReviewEntity reviewEntity) {
        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setReviewId(reviewEntity.getReviewId());
        reviewModel.setRating(reviewEntity.getRating());
        reviewModel.setComment(reviewEntity.getComment());
        reviewModel.setReviewDate(reviewEntity.getReviewDate());
        reviewModel.setTripId(reviewEntity.getTripId());

        // Set customer ID if customer exists
        if (reviewEntity.getCustomer() != null) {
            reviewModel.setCustomerId(reviewEntity.getCustomer().getCustomerId());
        }
        return reviewModel;
    }

    // Convert ReviewModel to ReviewEntity
    public static ReviewEntity convertReviewModelToReviewEntity(ReviewModel reviewModel, 
                                                                CustomerRepository customerRepository) throws BadRequestException {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setReviewId(reviewModel.getReviewId());
        reviewEntity.setRating(reviewModel.getRating());
        reviewEntity.setComment(reviewModel.getComment());
        reviewEntity.setReviewDate(reviewModel.getReviewDate());
        reviewEntity.setTripId(reviewModel.getTripId());

        // Fetch customer from repository if customer ID is present
        if (reviewModel.getCustomerId() != 0) {
            CustomerEntity customerEntity = customerRepository.findById(reviewModel.getCustomerId())
                    .orElseThrow(() -> new BadRequestException("Customer not found"));
            reviewEntity.setCustomer(customerEntity);
        }

        return reviewEntity;
    }

    // Convert a list of ReviewModels to a list of ReviewEntities
    public static List<ReviewEntity> convertListOfReviewModelToReviewEntity(List<ReviewModel> reviewModelList, 
                                                                            CustomerRepository customerRepository) throws BadRequestException {
        List<ReviewEntity> reviewEntityList = new ArrayList<>();
        for (ReviewModel reviewModel : reviewModelList) {
            reviewEntityList.add(convertReviewModelToReviewEntity(reviewModel, customerRepository));
        }
        return reviewEntityList;
    }

    // Convert a list of ReviewEntities to a list of ReviewModels
    public static List<ReviewModel> convertListOfReviewEntityToReviewModel(List<ReviewEntity> reviewEntityList) {
        List<ReviewModel> reviewModelList = new ArrayList<>();
        for (ReviewEntity reviewEntity : reviewEntityList) {
            reviewModelList.add(convertReviewEntityToReviewModel(reviewEntity));
        }
        return reviewModelList;
    }

    // Convert a list of ReviewEntities to a Set of ReviewModels (optional, if you need a Set)
    public static Set<ReviewModel> convertSetOfReviewEntityToReviewModel(List<ReviewEntity> reviewEntityList) {
        Set<ReviewModel> reviewModelSet = new HashSet<>();
        for (ReviewEntity reviewEntity : reviewEntityList) {
            reviewModelSet.add(convertReviewEntityToReviewModel(reviewEntity));
        }
        return reviewModelSet;
    }
}
 