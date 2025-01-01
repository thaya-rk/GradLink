package com.thaya.gradlink.backend.repository;

import com.thaya.gradlink.backend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    // Find company by name
    List<Company> findByName(String name);

    // Find companies by HR email
    List<Company> findByHrEmail(String hrEmail);


}
