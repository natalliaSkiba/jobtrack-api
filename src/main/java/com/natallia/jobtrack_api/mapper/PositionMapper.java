package com.natallia.jobtrack_api.mapper;

import com.natallia.jobtrack_api.dto.PositionResponse;
import com.natallia.jobtrack_api.model.Position;
import org.springframework.stereotype.Component;

@Component
public class PositionMapper {

    public PositionResponse toResponse(Position position){
        return PositionResponse.builder()
                .id(position.getId())
                .titleName(position.getTitleName())
                .build();
    }
}
