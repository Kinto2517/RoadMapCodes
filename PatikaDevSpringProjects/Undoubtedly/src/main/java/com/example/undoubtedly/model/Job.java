package com.example.undoubtedly.model;

import javax.persistence.*;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "job_location")
    private String jobLocation;

    @Column(name = "job_type")
    private String jobType;

    @Column(name = "job_salary")
    private String jobSalary;


}
