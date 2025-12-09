package com.example.jobportal.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Job {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(length = 2000)
    private String description;
    private String location;
    private LocalDate closingDate;

    public Job(){}

    public Job(Long id, String title, String description, String location, LocalDate closingDate){
        this.id=id; this.title=title; this.description=description; this.location=location; this.closingDate=closingDate;
    }

    // getters/setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}
    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}
    public String getLocation(){return location;}
    public void setLocation(String location){this.location=location;}
    public LocalDate getClosingDate(){return closingDate;}
    public void setClosingDate(LocalDate closingDate){this.closingDate=closingDate;}
}
