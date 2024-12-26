package com.example.gradlink.repository;

import com.example.gradlink.entity.TPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TPORepository extends JpaRepository<TPO, Long> {

    // Find TPO by email
    Optional<TPO> findByEmail(String email);

    // Find TPOs by department
    List<TPO> findByDept(String dept);
}
