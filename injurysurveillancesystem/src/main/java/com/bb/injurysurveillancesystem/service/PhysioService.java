package com.bb.injurysurveillancesystem.service;

import com.bb.injurysurveillancesystem.dto.input.PhysioInputDto;
import com.bb.injurysurveillancesystem.dto.output.PhysioOutputDto;
import com.bb.injurysurveillancesystem.entity.PhysioEntity;
import com.bb.injurysurveillancesystem.mapper.PhysioMapper;
import com.bb.injurysurveillancesystem.repository.PhysioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhysioService {
    @Autowired
    private PhysioRepository physioRepo;

    public PhysioOutputDto createPhysio(PhysioInputDto physioInputDto) {
        PhysioEntity entity = PhysioMapper.INSTANCE.toPhysioEntity(physioInputDto);
        entity = physioRepo.save(entity);
        return PhysioMapper.INSTANCE.toPhysioOutputDto(entity);
    }

    public List<PhysioOutputDto> getPhysios() {
        List<PhysioEntity> physioEntities = physioRepo.findAll();
        return PhysioMapper.INSTANCE.toPhysioOutputDtos(physioEntities);
    }

    public PhysioOutputDto getPhysioById(Long id) {
        PhysioEntity physioEntity = physioRepo.getById(id);
        return PhysioMapper.INSTANCE.toPhysioOutputDto(physioEntity);
    }
}
