package com.example.jobportal.model;

import jakarta.persistence.*;

@Entity
public class Applicant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    @Column(length = 2000)
    private String resumeText;

    public Applicant(){}
    public Applicant(Long id, String email, String name, String resumeText){
        this.id=id; this.email=email; this.name=name; this.resumeText=resumeText;
    }

    // getters/setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getResumeText(){return resumeText;}
    public void setResumeText(String resumeText){this.resumeText=resumeText;}
}
