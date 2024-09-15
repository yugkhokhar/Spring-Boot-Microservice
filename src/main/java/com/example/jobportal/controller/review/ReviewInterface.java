package com.example.jobportal.controller.review;

import java.util.List;

public interface ReviewInterface {
    public Boolean giveReview(ReviewEntity review);
    public List<ReviewEntity> getAllReviews();
    List<ReviewEntity> getSpecificCompanyReview(int id);
    ReviewEntity getReviewFromCompany(int companyId,int reviewId);
    public Boolean updateReview(ReviewEntity review);
    public Boolean deleteReview(int id);
    public Boolean deleteCompanyReviews(int companyId);
}
