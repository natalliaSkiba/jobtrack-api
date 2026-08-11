package com.natallia.jobtrack_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "position_id", nullable = false)
    @ManyToOne(optional = false)
    private Position position;

    @JoinColumn(name = "company_id", nullable = false)
    @ManyToOne(optional = false)
    private Company company;

    @Column(name = "vacancy_url")
    private String vacancyUrl;

    @Column(name = "city")
    private String city;

    @Column(name = "work_mode", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    private WorkMode workMode;

    @Column(name = "contract_type", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    private ContractType contractType;

    @Column(name = "salary_min")
    @Positive
    private Double salaryMin;

    @Column(name = "salary_max")
    @Positive
    private Double salaryMax;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    private ApplicationStatus status;

    @Column(name = "applied_at")
    private LocalDate appliedAt;

    @Column(name = "notes")
    private String notes;

}
