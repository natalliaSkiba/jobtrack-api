package com.natallia.jobtrack_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PositionResponse {
    private Long id;
    private String titleName;
}
