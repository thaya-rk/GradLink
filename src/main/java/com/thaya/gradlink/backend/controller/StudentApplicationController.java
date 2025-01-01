package com.thaya.gradlink.backend.controller;

import com.thaya.gradlink.backend.entity.StudentApplication;
import com.thaya.gradlink.backend.service.StudentApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class StudentApplicationController {

    private final StudentApplicationService studentApplicationService;

    @Autowired
    public StudentApplicationController(StudentApplicationService studentApplicationService) {
        this.studentApplicationService = studentApplicationService;
    }

    @PostMapping
    public ResponseEntity<StudentApplication> applyForJob(@RequestBody StudentApplication studentApplication) {
        StudentApplication createdApplication = studentApplicationService.applyForJob(studentApplication);
        return new ResponseEntity<>(createdApplication, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentApplication> updateApplication(@PathVariable Long id, @RequestBody StudentApplication studentApplication) {
        StudentApplication updatedApplication = studentApplicationService.updateApplication(id, studentApplication);
        return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentApplication> getApplicationById(@PathVariable Long id) {
        StudentApplication studentApplication = studentApplicationService.getApplicationById(id);
        return new ResponseEntity<>(studentApplication, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentApplication>> getAllApplications() {
        List<StudentApplication> applications = studentApplicationService.getAllApplications();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        studentApplicationService.deleteApplication(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
