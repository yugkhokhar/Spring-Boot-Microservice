package com.example.jobportal.controller.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRespository extends JpaRepository<JobEntity, Integer> {
}
