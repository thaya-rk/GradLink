package com.example.gradlink.service;

import com.example.gradlink.entity.Company;
import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company saveCompany(Company company);
    Company updateCompany(Long id, Company company);
    Optional<Company> getCompanyById(Long id);
    List<Company> getAllCompanies();
    void deleteCompany(Long id);
}
