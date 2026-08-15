package com.natallia.jobtrack_api.dto;

import com.natallia.jobtrack_api.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class JobResponse {

    private Long id;

    private Long positionId;

    private String positionTitle;

    private Long companyId;

    private String companyName;

    private String vacancyUrl;

    private String city;

    private WorkMode workMode;

    private ContractType contractType;

    private BigDecimal salaryMin;

    private BigDecimal salaryMax;

    private ApplicationStatus status;

    private LocalDate appliedDate;

    private String notes;
}
