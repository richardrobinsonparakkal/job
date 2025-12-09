package com.example.jobportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.jobportal.model.Job;
import com.example.jobportal.repository.JobRepository;

import java.time.LocalDate;

@Controller
@RequestMapping("/jobs")
public class JobController {

    private final JobRepository jobRepo;

    public JobController(JobRepository jobRepo){
        this.jobRepo = jobRepo;
    }

    @GetMapping("/new")
    public String newJobForm(Model model){
        model.addAttribute("job", new Job());
        return "job_form";
    }

    @PostMapping("/save")
    public String save(Job job){
        if (job.getClosingDate() == null) job.setClosingDate(LocalDate.now().plusDays(30));
        jobRepo.save(job);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        jobRepo.deleteById(id);
        return "redirect:/";
    }
}
