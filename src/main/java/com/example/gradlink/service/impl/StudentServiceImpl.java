package com.example.gradlink.service.impl;

import com.example.gradlink.entity.Student;
import com.example.gradlink.repository.StudentRepository;
import com.example.gradlink.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = getStudentById(id);
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setSchool10thPercentage(student.getSchool10thPercentage());
        existingStudent.setSchool12thPercentage(student.getSchool12thPercentage());
        existingStudent.setCollegeCgpa(student.getCollegeCgpa());
        existingStudent.setResume(student.getResume());
        existingStudent.setApplicationStatus(student.getApplicationStatus());
        existingStudent.setBatch(student.getBatch());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
