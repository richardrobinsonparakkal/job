package com.example.jobportal.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity(name="applications")
public class Application {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Applicant applicant;

    @ManyToOne
    private Job job;

    private String status; // Pending, Accepted, Rejected
    private LocalDate appliedOn;

    public Application(){}
    public Application(Long id, Applicant applicant, Job job, String status, LocalDate appliedOn){
        this.id=id; this.applicant=applicant; this.job=job; this.status=status; this.appliedOn=appliedOn;
    }

    // getters/setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Applicant getApplicant(){return applicant;}
    public void setApplicant(Applicant applicant){this.applicant=applicant;}
    public Job getJob(){return job;}
    public void setJob(Job job){this.job=job;}
    public String getStatus(){return status;}
    public void setStatus(String status){this.status=status;}
    public LocalDate getAppliedOn(){return appliedOn;}
    public void setAppliedOn(LocalDate appliedOn){this.appliedOn=appliedOn;}
}
