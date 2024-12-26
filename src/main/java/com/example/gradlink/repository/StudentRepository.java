package com.example.gradlink.repository;

import com.example.gradlink.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByName(String name);

    List<Student> findByIsCurrentStudentTrue();
    List<Student> FindByIsCurrentStudentFalse();
    List<Student> findByBatch(String batch);
    List<Student> findByTpoId(Long tpoId);
    List<Student> findByDept(String dept);

}
