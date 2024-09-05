package com.example.jobportal.controller.job;

import java.util.List;

public interface JobServiceInterface {
    List<JobEntity> findAll();
    JobEntity findById(int id);
    Boolean createJob(JobEntity jobEntity);
    Boolean updateJob(JobEntity jobEntity);
    Boolean deleteJob(int id);
}
