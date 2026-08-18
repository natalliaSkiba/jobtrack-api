package com.natallia.jobtrack_api.dto;

import com.natallia.jobtrack_api.model.ApplicationStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class JobStatusUpdateRequest {
    @NotNull(message = "Status is required")
    private ApplicationStatus status;
}
