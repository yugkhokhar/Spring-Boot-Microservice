package com.example.jobportal.controller.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    ReviewService reviewService;

    ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/getAllReviews")
    public ResponseEntity<List<ReviewEntity>> getAllReviews() {
        List<ReviewEntity> reviews = reviewService.getAllReviews();
        if (reviews.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/getSpecificCompanyReview/{id}")
    public ResponseEntity<List<ReviewEntity>> getSpecificCompany(@PathVariable int id) {

        List<ReviewEntity> companyReviews = reviewService.getSpecificCompanyReview(id);
        if (companyReviews.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(companyReviews, HttpStatus.OK);
    }

    @PostMapping("/giveReview")
    public ResponseEntity<String> giveReview(@RequestBody ReviewEntity review) {
        Boolean status = reviewService.giveReview(review);
        if (status) {
            return new ResponseEntity<>("Reviewed Added Successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Error in Creating Review", HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PutMapping("/updateReview")
    public ResponseEntity<String> updateReview(@RequestBody ReviewEntity review) {
        Boolean status = reviewService.updateReview(review);
        if (status) {
            return new ResponseEntity<>("Review Updated Successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Error in Updating Review", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {

        Boolean status = reviewService.deleteReview(id);
        if (status) {
            return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Error in Deleting Review", HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("/{companyId}/{id}")
    public ResponseEntity<ReviewEntity> delete(@PathVariable int id,@PathVariable int companyId) {

        ReviewEntity review = reviewService.getReviewFromCompany(companyId,id);
        if (review!=null) {
            return new ResponseEntity<>(review, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @DeleteMapping("/deleteCompanyReview/{companyId}")
    public ResponseEntity<String> deleteCompanyReview(@PathVariable int companyId) {
        Boolean status = reviewService.deleteCompanyReviews(companyId);
        if (status) {
            return new ResponseEntity<>("All Reviews Deleted Successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Error in Deleting Reviews", HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
