package com.example.jobportal.controller.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/job")
public class JobController {

    public List<Job> jobs=new ArrayList<>();
    @GetMapping("/getAllJobs")
    public List<Job> getAllJobs(){
        return jobs;
    }

    @PostMapping("/createJob")
    public String createJob(@RequestBody Job job){
         jobs.add(job);
         return "Job Created Successfully";
    }
}
