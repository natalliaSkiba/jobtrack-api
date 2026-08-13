package com.natallia.jobtrack_api.service;

import com.natallia.jobtrack_api.exception.ResourceNotFoundException;
import com.natallia.jobtrack_api.model.Company;
import com.natallia.jobtrack_api.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company is not found with id: " + id));
    }

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public void deleteCompanyById(Long id) {
        getCompanyById(id);
        companyRepository.deleteById(id);
    }
    public List<Company> getCompaniesByNameContainingIgnoreCase(String name){
        return companyRepository.findByNameContainingIgnoreCase(name);
    }

}
