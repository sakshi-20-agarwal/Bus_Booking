package com.sprint.btb.service;


import com.sprint.btb.model.ReviewModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReviewService {

    private final String customerServiceUrl = "http://localhost:9092/api/reviews"; // URL to the review controller in the customer microservice

    private final RestTemplate restTemplate;

    public ReviewService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ReviewModel createReview(ReviewModel reviewModel) {
        try {
            // Making a POST request to the Customer microservice to create the review
            return restTemplate.postForObject(customerServiceUrl + "/add", reviewModel, ReviewModel.class);
        } catch (Exception e) {
            // Handle any errors or exceptions that occur during the request
            throw new RuntimeException("Error while creating review: " + e.getMessage());
        }
    }
}
