package com.bb.injurysurveillancesystem.repository;

import com.bb.injurysurveillancesystem.entity.AthleteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<AthleteEntity, Long> {
}
