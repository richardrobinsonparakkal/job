package com.example.jobportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.jobportal.repository.JobRepository;
import com.example.jobportal.repository.ApplicationRepository;

@Controller
public class HomeController {

    private final JobRepository jobRepo;
    private final ApplicationRepository appRepo;

    public HomeController(JobRepository jobRepo, ApplicationRepository appRepo) {
        this.jobRepo = jobRepo;
        this.appRepo = appRepo;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("jobs", jobRepo.findAll());
        model.addAttribute("applications", appRepo.findAll());
        return "index";
    }
}
