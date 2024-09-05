package com.example.jobportal.controller.job;


import com.example.jobportal.controller.company.CompanyEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
//@Table(name="Jobs")
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String jobName;
    private String jobDescription;
    private Long minSalary;
    private Long maxSalary;

    @ManyToOne
    private CompanyEntity company;

    public JobEntity(){}

    public JobEntity(String jobName, String jobDescription, int id, Long minSalary, Long maxSalary,CompanyEntity company) {
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.id = id;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.company=company;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    public Long getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Long maxSalary) {
        this.maxSalary = maxSalary;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }
}
