package com.example.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jobportal.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {}
