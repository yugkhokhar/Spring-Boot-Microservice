package com.example.jobportal.controller.review;

import com.example.jobportal.controller.job.JobRespository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements ReviewInterface {

    private final JobRespository jobRespository;
    ReviewRespository reviewRepository;

    ReviewService(ReviewRespository reviewRepository, JobRespository jobRespository) {
        this.reviewRepository = reviewRepository;
        this.jobRespository = jobRespository;
    }

    @Override
    public Boolean giveReview(ReviewEntity review) {
        try {
            reviewRepository.save(review);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<ReviewEntity> getAllReviews() {
        List<ReviewEntity> reviews = reviewRepository.findAll();
        List<ReviewEntity> emptyReview = new ArrayList<>();
        if (reviews.isEmpty()) {
            return emptyReview;
        }
        return reviews;
    }

//    @Override
//    public List<ReviewEntity> getSpecificCompanyReview(int id) {
//
//        List<ReviewEntity> reviews = reviewRepository.
//    }

    @Override
    public Boolean updateReview(ReviewEntity review) {

        if(reviewRepository.existsById(review.getId())) {
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteReview(int id) {
        if(reviewRepository.existsById((long) id)){
            reviewRepository.deleteById((long) id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteCompanyReviews(int companyId) {
        return null;
    }
}
