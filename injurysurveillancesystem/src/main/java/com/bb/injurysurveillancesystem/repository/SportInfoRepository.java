package com.bb.injurysurveillancesystem.repository;

import com.bb.injurysurveillancesystem.entity.SportInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportInfoRepository extends JpaRepository<SportInfoEntity, Long> {
}
