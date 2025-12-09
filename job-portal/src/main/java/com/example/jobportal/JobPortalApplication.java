package com.example.jobportal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.jobportal.model.*;
import com.example.jobportal.repository.*;

import java.time.LocalDate;

@SpringBootApplication
public class JobPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobPortalApplication.class, args);
    }

    // Seed some initial data
    @Bean
    CommandLineRunner initData(UserRepository userRepo, JobRepository jobRepo, ApplicantRepository applicantRepo, ApplicationRepository appRepo) {
        return args -> {
            if (userRepo.count() == 0) {
                User hr = new User(null, "hr@company.com", "HR Manager", "HR");
                userRepo.save(hr);
            }
            if (jobRepo.count() == 0) {
                Job j1 = new Job(null, "Java Developer", "Backend developer (Spring Boot)", "Bangalore", LocalDate.now().plusDays(10));
                Job j2 = new Job(null, "Frontend Developer", "React/Angular", "Remote", LocalDate.now().plusDays(20));
                jobRepo.save(j1);
                jobRepo.save(j2);
            }
            if (applicantRepo.count() == 0) {
                Applicant a1 = new Applicant(null, "alice@example.com", "Alice", "Resume text for Alice");
                applicantRepo.save(a1);
                // Apply Alice to Java Developer
                Application ap = new Application(null, a1, jobRepo.findAll().get(0), "Pending", LocalDate.now());
                appRepo.save(ap);
            }
        };
    }
}
