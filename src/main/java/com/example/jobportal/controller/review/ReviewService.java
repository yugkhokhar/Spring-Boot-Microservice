package com.example.jobportal.controller.review;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService implements ReviewInterface {

    ReviewRespository reviewRepository;

    ReviewService(ReviewRespository reviewRepository) {
        this.reviewRepository = reviewRepository;

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

    @Override
    public List<ReviewEntity> getSpecificCompanyReview(int id) {
        return reviewRepository.findByCompanyId(id);
    }

    @Override
    public Boolean updateReview(ReviewEntity review) {

        if (reviewRepository.existsById(review.getId())) {
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteReview(int id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteCompanyReviews(int companyId) {
        try {
            reviewRepository.deleteByCompanyId(companyId);
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    public ReviewEntity getReviewFromCompany(int companyId, int id) {
        List<ReviewEntity> reviews = reviewRepository.findByCompanyId(companyId);

       return reviews.stream().filter(reviewEntity -> reviewEntity.getId()==id).findFirst().orElse(null);
    }

}
