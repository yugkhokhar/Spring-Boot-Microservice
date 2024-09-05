package com.example.jobportal.controller.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job")
public class JobController {
    JobService jobService;

    JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/getAllJobs")
    public ResponseEntity<List<JobEntity>> getAllJobs() {
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/createJob")
    public ResponseEntity<String> createJob(@RequestBody JobEntity jobEntity) {
        Boolean status = jobService.createJob(jobEntity);
        if (status) {
            return new ResponseEntity<>("Job Created Successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Job Creation Failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobEntity> getJob(@PathVariable Long id) {
        JobEntity jobEntity = jobService.findById(Math.toIntExact(id));
        if(jobEntity !=null) {
        return new ResponseEntity<>(jobEntity, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateJob(@RequestBody JobEntity jobEntity) {
        Boolean status = jobService.updateJob(jobEntity);
        if (status) {
            return new ResponseEntity<>("Job Updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job Update Failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable int id) {
        Boolean del = jobService.deleteJob(id);
        if (del) {
            return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job Deleted Failed", HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
