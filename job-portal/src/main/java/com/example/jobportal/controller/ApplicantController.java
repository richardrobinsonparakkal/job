package com.example.jobportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.jobportal.model.*;
import com.example.jobportal.repository.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/apply")
public class ApplicantController {

    private final ApplicantRepository applicantRepo;
    private final JobRepository jobRepo;
    private final ApplicationRepository appRepo;

    public ApplicantController(ApplicantRepository applicantRepo, JobRepository jobRepo, ApplicationRepository appRepo){
        this.applicantRepo = applicantRepo;
        this.jobRepo = jobRepo;
        this.appRepo = appRepo;
    }

    @GetMapping("/{jobId}")
    public String applyForm(@PathVariable Long jobId, Model model){
        model.addAttribute("job", jobRepo.findById(jobId).orElse(null));
        model.addAttribute("applicant", new Applicant());
        return "apply_form";
    }

    @PostMapping("/{jobId}")
    public String submitApplication(@PathVariable Long jobId, Applicant applicant){
        Applicant saved = applicantRepo.save(applicant);
        Job job = jobRepo.findById(jobId).orElse(null);
        Application app = new Application();
        app.setApplicant(saved);
        app.setJob(job);
        app.setStatus("Pending");
        app.setAppliedOn(LocalDate.now());
        appRepo.save(app);
        return "redirect:/";
    }
}
