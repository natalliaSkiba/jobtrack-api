package com.natallia.jobtrack_api.service;

import com.natallia.jobtrack_api.dto.PositionResponse;
import com.natallia.jobtrack_api.exception.DuplicateResourceException;
import com.natallia.jobtrack_api.exception.ResourceNotFoundException;
import com.natallia.jobtrack_api.mapper.PositionMapper;
import com.natallia.jobtrack_api.model.Position;
import com.natallia.jobtrack_api.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;
    private  final PositionMapper positionMapper;

    private List<PositionResponse> mapToResponses (List<Position> positionList) {
        return positionList.stream().map(positionMapper::toResponse).toList();
    }

    public PositionResponse getPositionById(Long id){
        return positionMapper.toResponse(findPositionById(id));
    }

    public Position findPositionById(Long id) {
        return positionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Position is not found with id " + id));
    }

    public List<PositionResponse> getPositionsByNameContainingIgnoreCase(String titleName){
        return mapToResponses(positionRepository.findByTitleNameContainingIgnoreCase(titleName));
    }

    public List<PositionResponse> getAllPositions() {
        return mapToResponses(positionRepository.findAll());
    }

    public PositionResponse savePosition(Position position) {
        if (positionRepository.existsByTitleNameIgnoreCase(position.getTitleName())){
            throw new DuplicateResourceException("Position already exists: " + position.getTitleName());
        }
        return positionMapper.toResponse(positionRepository.save(position));
    }

    public void deletePositionById(Long id) {
        findPositionById(id);
        positionRepository.deleteById(id);
    }
}
