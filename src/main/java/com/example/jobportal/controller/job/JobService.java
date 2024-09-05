package com.example.jobportal.controller.job;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobService implements JobServiceInterface {

    //    List<Job> jobs = new ArrayList<>();
    JobRespository jobRepo;

    public JobService(JobRespository jobRespository) {
        this.jobRepo = jobRespository;
    }
//    int nextJobId = 1;

    @Override
    public List<JobEntity> findAll() {
        return jobRepo.findAll();
    }

    @Override
    public JobEntity findById(int id) {
        return jobRepo.findById(id).orElse(null);
    }

    @Override
    public Boolean createJob(JobEntity jobEntity) {
//        job.setId(nextJobId++);
        jobRepo.save(jobEntity);
        return true;
    }


    @Override
    public Boolean updateJob(JobEntity jobEntity) {
        Optional<JobEntity> optional = jobRepo.findById(jobEntity.getId());
        if (optional.isPresent()) {
            JobEntity jb = optional.get();
            jb.setJobName(jobEntity.getJobName());
            jb.setJobDescription(jobEntity.getJobDescription());
            jb.setMinSalary(jobEntity.getMinSalary());
            jb.setMaxSalary(jobEntity.getMaxSalary());
            jb.setCompany(jobEntity.getCompany());
            jobRepo.save(jb);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteJob(int id) {
        try {
            if (jobRepo.existsById(id)) {
                jobRepo.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
