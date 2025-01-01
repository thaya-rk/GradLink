package com.thaya.gradlink.backend.repository;

import com.thaya.gradlink.backend.entity.StudentApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentApplicationRepository extends JpaRepository<StudentApplication, Long> {

}
