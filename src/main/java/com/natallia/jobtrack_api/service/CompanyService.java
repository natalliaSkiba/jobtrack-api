package com.natallia.jobtrack_api.service;

import com.natallia.jobtrack_api.dto.CompanyResponse;
import com.natallia.jobtrack_api.exception.DuplicateResourceException;
import com.natallia.jobtrack_api.exception.ResourceNotFoundException;
import com.natallia.jobtrack_api.mapper.CompanyMapper;
import com.natallia.jobtrack_api.model.Company;
import com.natallia.jobtrack_api.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;


    private List<CompanyResponse> mapToResponses(List<Company> companyList) {
        return companyList.stream().map(companyMapper::toResponse).toList();
    }

    public Company findCompanyById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company is not found with id: " + id));
    }

    public CompanyResponse getCompanyById(Long id){
        return companyMapper.toResponse(findCompanyById(id));
    }

    public List<CompanyResponse> getAllCompanies() {
        return mapToResponses(companyRepository.findAll());
    }

    public CompanyResponse saveCompany(Company company) {
        if (companyRepository.existsByNameIgnoreCase(company.getName())) {
            throw new DuplicateResourceException("Company already exists " + company.getName());
        }
        return companyMapper.toResponse(companyRepository.save(company));
    }

    public void deleteCompanyById(Long id) {
        findCompanyById(id);
        companyRepository.deleteById(id);
    }

    public List<CompanyResponse> getCompaniesByNameContainingIgnoreCase(String name) {
        return mapToResponses(companyRepository.findByNameContainingIgnoreCase(name));
    }

}
