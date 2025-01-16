package com.thaya.gradlink.backend.controller;

import com.thaya.gradlink.backend.entity.Company;
import com.thaya.gradlink.backend.entity.Student;
import com.thaya.gradlink.backend.entity.StudentApplication;
import com.thaya.gradlink.backend.service.CompanyService;
import com.thaya.gradlink.backend.service.StudentApplicationService;
import com.thaya.gradlink.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class StudentApplicationController {

    private final StudentApplicationService studentApplicationService;
    private final StudentService studentService;
    private final CompanyService companyService;

    @Autowired
    public StudentApplicationController(StudentApplicationService studentApplicationService,
                                        StudentService studentService,
                                        CompanyService companyService) {
        this.studentApplicationService = studentApplicationService;
        this.studentService = studentService;
        this.companyService = companyService;
    }


    @PostMapping
    public ResponseEntity<StudentApplication> applyForJob(@RequestBody StudentApplication studentApplication) {
        // Fetch the Student and Company by id
        Student student = studentService.getStudentById(studentApplication.getStudent().getId());
        Company company = companyService.getCompanyById(studentApplication.getCompany().getId());

        // Set the fetched entities in the application
        studentApplication.setStudent(student);
        studentApplication.setCompany(company);

        // Apply for the job and save the application
        StudentApplication createdApplication = studentApplicationService.applyForJob(studentApplication);

        return new ResponseEntity<>(createdApplication, HttpStatus.CREATED);
    }
    //Update a application
    @PutMapping("/{id}")
    public ResponseEntity<StudentApplication> updateApplication(@PathVariable Long id, @RequestBody StudentApplication studentApplication) {
        StudentApplication updatedApplication = studentApplicationService.updateApplication(id, studentApplication);
        return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
    }

    //Get applications details of a student
    @GetMapping("/{id}")
    public ResponseEntity<StudentApplication> getApplicationById(@PathVariable Long id) {
        StudentApplication studentApplication = studentApplicationService.getApplicationById(id);
        return new ResponseEntity<>(studentApplication, HttpStatus.OK);
    }

    //Get all application details
    @GetMapping
    public ResponseEntity<List<StudentApplication>> getAllApplications() {
        List<StudentApplication> applications = studentApplicationService.getAllApplications();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    //Delete a application
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        studentApplicationService.deleteApplication(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
