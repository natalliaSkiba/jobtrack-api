package com.natallia.jobtrack_api.controller;

import com.natallia.jobtrack_api.model.Position;
import com.natallia.jobtrack_api.service.PositionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/positions")
public class PositionController {
    private final PositionService positionService;

    @GetMapping("/{id}")
    public ResponseEntity<Position> getPositionById(@PathVariable Long id) {
        return ResponseEntity.ok(positionService.getPositionById(id));
    }

    @GetMapping
    public ResponseEntity<List<Position>> getAllPositions() {
        return ResponseEntity.ok(positionService.getAllPositions());
    }

    @PostMapping()
    public ResponseEntity<Position> createPosition(@Valid @RequestBody Position position) {
        return ResponseEntity.status(HttpStatus.CREATED).body(positionService.savePosition(position));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePositionById(@PathVariable Long id) {
        positionService.deletePositionById(id);
        return ResponseEntity.noContent().build();
    }

}
