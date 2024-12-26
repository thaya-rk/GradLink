package com.thaya.gradlink.service;

import com.thaya.gradlink.entity.StudentApplication;

import java.util.List;

public interface StudentApplicationService {
    StudentApplication applyForJob(StudentApplication studentApplication);
    List<StudentApplication> getAllApplications();
    StudentApplication getApplicationById(Long id);
    StudentApplication updateApplication(Long id, StudentApplication studentApplication);
    void deleteApplication(Long id);
}
