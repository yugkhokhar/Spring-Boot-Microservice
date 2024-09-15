package com.example.jobportal.controller.company;


import com.example.jobportal.controller.job.JobEntity;
import com.example.jobportal.controller.review.ReviewEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String companyAddress;
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<JobEntity> jobs;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<ReviewEntity>reviews;

    public CompanyEntity(){
    }

    public CompanyEntity(String name, String companyAddress, String type,List<JobEntity>jobs,List<ReviewEntity>reviews) {
        this.name = name;
        this.companyAddress = companyAddress;
        this.type = type;
        this.jobs=jobs;
        this.reviews=reviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<JobEntity> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobEntity> jobs) {
        this.jobs = jobs;
    }

    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
    }
}
