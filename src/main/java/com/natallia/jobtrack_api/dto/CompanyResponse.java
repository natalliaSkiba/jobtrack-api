package com.natallia.jobtrack_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
public class CompanyResponse {
    private Long id;
    private String name;
}
