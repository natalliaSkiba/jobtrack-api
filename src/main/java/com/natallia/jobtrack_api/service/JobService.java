package com.natallia.jobtrack_api.service;

import com.natallia.jobtrack_api.dto.JobCreateRequest;
import com.natallia.jobtrack_api.dto.JobResponse;
import com.natallia.jobtrack_api.exception.InvalidSalaryRangeException;
import com.natallia.jobtrack_api.exception.ResourceNotFoundException;
import com.natallia.jobtrack_api.mapper.JobMapper;
import com.natallia.jobtrack_api.model.ApplicationStatus;
import com.natallia.jobtrack_api.model.Company;
import com.natallia.jobtrack_api.model.Job;
import com.natallia.jobtrack_api.model.Position;
import com.natallia.jobtrack_api.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;
    private final CompanyService companyService;
    private final PositionService positionService;
    private final JobMapper jobMapper;

    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Job is not found with id: " + id));
    }

    public List<Job> getJobsByCityContainingIgnoreCase(String city) {
        return jobRepository.findByCityContainingIgnoreCase(city);
    }

    public List<Job> getJobsByCompanyNameContainingIgnoreCase(String companyName) {
        return jobRepository.findByCompany_NameContainingIgnoreCase(companyName);
    }

    public List<Job> getJobsByPositionTitleNameContainingIgnoreCase(String positionTitleName) {
        return jobRepository.findByPosition_TitleNameContainingIgnoreCase(positionTitleName);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public JobResponse saveJob(JobCreateRequest request) {

        Position position = positionService.getPositionById(request.getPositionId());
        Company company = companyService.getCompanyById(request.getCompanyId());
        Job job = Job.builder()
                .position(position)
                .company(company)
                .vacancyUrl(request.getVacancyUrl())
                .city(request.getCity())
                .workMode(request.getWorkMode())
                .contractType(request.getContractType())
                .salaryMin(request.getSalaryMin())
                .salaryMax(request.getSalaryMax())
                .status(ApplicationStatus.SAVED)
                .notes(request.getNotes())
                .build();

        if (job.getSalaryMin() != null
                && job.getSalaryMax() != null
                && job.getSalaryMin().compareTo(job.getSalaryMax()) > 0) {
            throw new InvalidSalaryRangeException("Salary max cannot be less than salary min");
        }
        Job savedJob = jobRepository.save(job);
        return jobMapper.toResponse(savedJob);
    }

    public void deleteJobById(Long id) {
        getJobById(id);
        jobRepository.deleteById(id);
    }
}
