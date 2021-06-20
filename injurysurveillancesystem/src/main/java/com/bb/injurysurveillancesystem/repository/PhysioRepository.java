package com.bb.injurysurveillancesystem.repository;

import com.bb.injurysurveillancesystem.entity.PhysioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysioRepository extends JpaRepository<PhysioEntity, Long> {
}
