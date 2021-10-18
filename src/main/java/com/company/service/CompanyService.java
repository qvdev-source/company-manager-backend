package com.company.service;

import com.company.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    Company addCompany(Company company, long id);

    Company editCompany(Company company, long id);

    Company findCompany(long id);

    void deleteCompany(long id);

    List<Company> findCompanies();

}
