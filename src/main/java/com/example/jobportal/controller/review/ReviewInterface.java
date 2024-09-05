package com.example.jobportal.controller.review;

import java.util.List;

public interface ReviewInterface {
    public Boolean giveReview(ReviewEntity review);
    public List<ReviewEntity> getAllReviews();
//    public List<ReviewEntity>getSpecificCompanyReview(int id);
    public Boolean updateReview(ReviewEntity review);
    public Boolean deleteReview(int id);
    public Boolean deleteCompanyReviews(int companyId);
}
