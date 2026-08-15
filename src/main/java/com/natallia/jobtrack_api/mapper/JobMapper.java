package com.natallia.jobtrack_api.mapper;

import com.natallia.jobtrack_api.dto.JobResponse;
import com.natallia.jobtrack_api.model.Job;
import org.springframework.stereotype.Component;

@Component

public class JobMapper {

    public JobResponse toResponse(Job job) {
        return JobResponse.builder()
                .id(job.getId())
                .positionId(job.getPosition().getId())
                .positionTitle(job.getPosition().getTitleName())
                .companyId(job.getCompany().getId())
                .companyName(job.getCompany().getName())
                .vacancyUrl(job.getVacancyUrl())
                .city(job.getCity())
                .workMode(job.getWorkMode())
                .contractType(job.getContractType())
                .salaryMin(job.getSalaryMin())
                .salaryMax(job.getSalaryMax())
                .status(job.getStatus())
                .appliedDate(job.getAppliedDate())
                .notes(job.getNotes())
                .build();
    }
}
