package com.natallia.jobtrack_api.controller;

import com.natallia.jobtrack_api.dto.JobCreateRequest;
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

    @GetMapping(value = "/search/city", params = "city")
    public ResponseEntity<List<Job>> getJobsByCityContainingIgnoreCase(@RequestParam String city){
        return  ResponseEntity.ok(jobService.getJobsByCityContainingIgnoreCase(city));
    }

    @GetMapping(value = "/search/company", params = "company")
    public ResponseEntity<List<Job>> getJobsByCompanyNameContainingIgnoreCase(@RequestParam String company){
        return  ResponseEntity.ok(jobService.getJobsByCompanyNameContainingIgnoreCase(company));
    }

    @GetMapping(value = "/search/position", params = "position")
    public ResponseEntity<List<Job>> getJobsByPositionTitleNameContainingIgnoreCase(@RequestParam String position){
        return  ResponseEntity.ok(jobService.getJobsByPositionTitleNameContainingIgnoreCase(position));
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs(){
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @PostMapping()
    public ResponseEntity<Job> createJob(@Valid @RequestBody JobCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(jobService.saveJob(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobById(@PathVariable Long id){
        jobService.deleteJobById(id);
        return ResponseEntity.noContent().build();
    }
}
