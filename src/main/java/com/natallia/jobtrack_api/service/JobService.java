package com.natallia.jobtrack_api.service;

import com.natallia.jobtrack_api.exception.ResourceNotFoundException;
import com.natallia.jobtrack_api.model.Job;
import com.natallia.jobtrack_api.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;

    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job is not found with id: " + id));
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    public void deleteJobById(Long id) {
        getJobById(id);
        jobRepository.deleteById(id);
    }
}
