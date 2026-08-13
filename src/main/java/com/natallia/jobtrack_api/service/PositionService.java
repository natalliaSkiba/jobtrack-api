package com.natallia.jobtrack_api.service;

import com.natallia.jobtrack_api.exception.DuplicateResourceException;
import com.natallia.jobtrack_api.exception.ResourceNotFoundException;
import com.natallia.jobtrack_api.model.Position;
import com.natallia.jobtrack_api.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;

    public Position getPositionById(Long id) {
        return positionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Position is not found with id " + id));
    }

    public List<Position> getPositionsByNameContainingIgnoreCase(String titleName){
        return positionRepository.findByTitleNameContainingIgnoreCase(titleName);
    }

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public Position savePosition(Position position) {
        if (positionRepository.existsByTitleNameIgnoreCase(position.getTitleName())){
            throw new DuplicateResourceException("Position already exists: " + position.getTitleName());
        }
        return positionRepository.save(position);
    }

    public void deletePositionById(Long id) {
        getPositionById(id);
        positionRepository.deleteById(id);
    }
}
