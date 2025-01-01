package com.thaya.gradlink.backend.service.impl;

import com.thaya.gradlink.backend.entity.StudentApplication;
import com.thaya.gradlink.backend.repository.StudentApplicationRepository;
import com.thaya.gradlink.backend.service.StudentApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentApplicationServiceImpl implements StudentApplicationService {

    private final StudentApplicationRepository studentApplicationRepository;

    @Autowired
    public StudentApplicationServiceImpl(StudentApplicationRepository studentApplicationRepository) {
        this.studentApplicationRepository = studentApplicationRepository;
    }

    @Override
    public StudentApplication applyForJob(StudentApplication studentApplication) {
        return studentApplicationRepository.save(studentApplication);
    }

    @Override
    public List<StudentApplication> getAllApplications() {
        return studentApplicationRepository.findAll();
    }

    @Override
    public StudentApplication getApplicationById(Long id) {
        return studentApplicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found with ID: " + id));
    }

    @Override
    public StudentApplication updateApplication(Long id, StudentApplication studentApplication) {
        StudentApplication existingApplication = getApplicationById(id);
        existingApplication.setApplicationStatus(studentApplication.getApplicationStatus());
        existingApplication.setSelectedStatus(studentApplication.getSelectedStatus());
        return studentApplicationRepository.save(existingApplication);
    }

    @Override
    public void deleteApplication(Long id) {
        studentApplicationRepository.deleteById(id);
    }
}
