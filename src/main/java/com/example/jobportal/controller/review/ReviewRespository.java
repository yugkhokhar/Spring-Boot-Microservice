package com.example.jobportal.controller.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRespository extends JpaRepository<ReviewEntity,Integer> {
    List<ReviewEntity> findByCompanyId(int id);

    void deleteByCompanyId(int companyId);
}
