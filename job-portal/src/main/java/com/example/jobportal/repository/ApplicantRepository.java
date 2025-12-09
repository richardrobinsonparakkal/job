package com.example.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jobportal.model.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {}
