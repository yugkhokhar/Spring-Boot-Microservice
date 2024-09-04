package com.example.jobportal.controller.job;

public class Job {
    private String jobName;
    private String jobDescription;
    private Long id;
    private Long minSalary;
    private Long maxSalary;

    Job(String jobName, String jobDescription, Long id, Long minSalary, Long maxSalary) {
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.id = id;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
