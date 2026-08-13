package com.natallia.jobtrack_api.repository;

import com.natallia.jobtrack_api.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position,Long> {

     List<Position> findByTitleNameContainingIgnoreCase(String titleName);
     boolean existsByTitleNameIgnoreCase(String titleName);
}
