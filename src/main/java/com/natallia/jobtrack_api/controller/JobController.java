package com.natallia.jobtrack_api.controller;

import com.natallia.jobtrack_api.model.Job;
import com.natallia.jobtrack_api.service.JobService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs(){
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @PostMapping()
    public ResponseEntity<Job> createJob(@Valid @RequestBody Job job){
        return ResponseEntity.status(HttpStatus.CREATED).body(jobService.saveJob(job));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobById(@PathVariable Long id){
        jobService.deleteJobById(id);
        return ResponseEntity.noContent().build();
    }
}
