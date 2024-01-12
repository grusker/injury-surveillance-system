package com.bb.injurysurveillancesystem.repository;

import com.bb.injurysurveillancesystem.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
}
