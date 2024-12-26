package com.example.gradlink.service;
import com.example.gradlink.entity.Student;
import java.util.List;
public interface StudentService {
    Student createStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);
    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);

}
