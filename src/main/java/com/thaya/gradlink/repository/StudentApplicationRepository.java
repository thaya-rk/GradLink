package com.thaya.gradlink.repository;

import com.thaya.gradlink.entity.StudentApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentApplicationRepository extends JpaRepository<StudentApplication, Long> {

}
