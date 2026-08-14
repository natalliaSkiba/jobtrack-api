package com.natallia.jobtrack_api.dto;

import com.natallia.jobtrack_api.model.ContractType;
import com.natallia.jobtrack_api.model.WorkMode;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobCreateRequest {
    @NotNull(message = "Company is required")
    @Positive(message = "Invalid company selection")
    private Long companyId;

    @NotNull(message = "Position is required")
    @Positive(message = "Invalid position selection")
    private Long positionId;

    private String vacancyUrl;

    private String city;

    @NotNull(message = "Work mode is required")
    private WorkMode workMode;

    @NotNull(message = "Contract type is required")
    private ContractType contractType;

    @PositiveOrZero(message = "Salary cannot be negative")
    private BigDecimal salaryMin;

    @PositiveOrZero(message = "Salary cannot be negative")
    private BigDecimal salaryMax;

    private String notes;
}
