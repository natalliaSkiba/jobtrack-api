package com.natallia.jobtrack_api.repository;

import com.natallia.jobtrack_api.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
    List<Job> findByCityContainingIgnoreCase(String city);
    List<Job> findByCompany_NameContainingIgnoreCase(String companyName);
    List<Job> findByPosition_TitleNameContainingIgnoreCase(String positionTitleName);
}
