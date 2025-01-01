package com.thaya.gradlink.backend.service;

import com.thaya.gradlink.backend.entity.StudentApplication;

import java.util.List;

public interface StudentApplicationService {
    StudentApplication applyForJob(StudentApplication studentApplication);
    List<StudentApplication> getAllApplications();
    StudentApplication getApplicationById(Long id);
    StudentApplication updateApplication(Long id, StudentApplication studentApplication);
    void deleteApplication(Long id);
}
