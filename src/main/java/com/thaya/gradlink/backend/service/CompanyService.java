package com.thaya.gradlink.backend.service;

import com.thaya.gradlink.backend.entity.Company;
import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company saveCompany(Company company);
    Company updateCompany(Long id, Company company);
    Company getCompanyById(Long id);
    List<Company> getAllCompanies();
    void deleteCompany(Long id);
}
