package com.thaya.gradlink.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String phone;
    private Integer school10thPercentage;
    private Integer school12thPercentage;
    private Integer collegeCgpa;
    private String resume;
    private String applicationStatus = "not_applied";
    private LocalDate profileCreationDate = LocalDate.now();
    private Boolean isCurrentStudent = true;
    private String batch;
    private String department;  // Added department field

    @ManyToOne
    @JoinColumn(name = "tpo_id")
    private TPO tpo;



    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSchool10thPercentage() {
        return school10thPercentage;
    }

    public void setSchool10thPercentage(Integer school10thPercentage) {
        this.school10thPercentage = school10thPercentage;
    }

    public Integer getSchool12thPercentage() {
        return school12thPercentage;
    }

    public void setSchool12thPercentage(Integer school12thPercentage) {
        this.school12thPercentage = school12thPercentage;
    }

    public Integer getCollegeCgpa() {
        return collegeCgpa;
    }

    public void setCollegeCgpa(Integer collegeCgpa) {
        this.collegeCgpa = collegeCgpa;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public LocalDate getProfileCreationDate() {
        return profileCreationDate;
    }

    public void setProfileCreationDate(LocalDate profileCreationDate) {
        this.profileCreationDate = profileCreationDate;
    }

    public Boolean getCurrentStudent() {
        return isCurrentStudent;
    }

    public void setCurrentStudent(Boolean currentStudent) {
        isCurrentStudent = currentStudent;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public TPO getTpo() {
        return tpo;
    }

    public void setTpo(TPO tpo) {
        this.tpo = tpo;
    }
}
