package com.example.gradlink.repository;

import com.example.gradlink.entity.StudentApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentApplicationRepository extends JpaRepository<StudentApplication, Long> {

}
