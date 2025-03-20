package com.sprint.btb.ctrl;

import com.sprint.btb.model.ReviewModel;
import com.sprint.btb.service.ReviewService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Show the review form (GET method)
    @GetMapping("/addReview")
    public String showReviewForm() {
        return "review"; // Return the Thymeleaf template for the review form
    }

    // Handle the review submission (POST method)
    @PostMapping("/addReview")
    public String submitReview(@RequestParam("rating") int rating, 
                               @RequestParam("comment") String comment, 
                               Model model) {

        // Create ReviewModel and set its properties
        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setRating(rating);
        reviewModel.setComment(comment);
        reviewModel.setCustomerId(2);  // Example of setting default value
        reviewModel.setTripId(2); 
        
LocalDateTime currentDateTime = LocalDateTime.now();     
        // Set the current date and time to the reviewModel
        reviewModel.setReviewDate(currentDateTime);

        // Call the ReviewService to save the review in the database
        ReviewModel savedReview = reviewService.createReview(reviewModel);

        // If the review is successfully saved, show a success message
        if (savedReview != null) {
            model.addAttribute("message", "Your review has been successfully submitted!");
            model.addAttribute("messageType", "success");
        } else {
            // If something goes wrong, show an error message
            model.addAttribute("message", "There was an error while submitting your review. Please try again.");
            model.addAttribute("messageType", "error");
        }

        // Return the view name, the message will be displayed on the review page
        return "review"; // Return the Thymeleaf template name
    }
}
