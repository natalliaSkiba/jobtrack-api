package com.natallia.jobtrack_api.mapper;

import com.natallia.jobtrack_api.dto.CompanyResponse;
import com.natallia.jobtrack_api.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
    public CompanyResponse toResponse(Company company){
        return CompanyResponse.builder()
                .id(company.getId())
                .name(company.getName())
                .build();
    }
}
