package com.bb.injurysurveillancesystem.service;

import com.bb.injurysurveillancesystem.dto.input.AthleteInputDto;
import com.bb.injurysurveillancesystem.dto.output.AthleteOutputDto;
import com.bb.injurysurveillancesystem.dto.output.PhysioOutputDto;
import com.bb.injurysurveillancesystem.entity.AthleteEntity;
import com.bb.injurysurveillancesystem.entity.PhysioEntity;
import com.bb.injurysurveillancesystem.mapper.AthleteMapper;
import com.bb.injurysurveillancesystem.mapper.PhysioMapper;
import com.bb.injurysurveillancesystem.repository.AthleteRepository;
import com.bb.injurysurveillancesystem.repository.PhysioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthleteService {
    @Autowired
    private AthleteRepository athleteRepo;
    @Autowired
    private PhysioService physioService;

    public AthleteOutputDto createAthlete(AthleteInputDto inputDto) {
        PhysioOutputDto physioOutputDto = physioService.getPhysioById(inputDto.getPhysioId());
        PhysioEntity physioEntity = PhysioMapper.INSTANCE.toPhysioEntity(physioOutputDto);
        AthleteEntity athleteEntity = AthleteMapper.INSTANCE.toAthleteEntity(inputDto, physioEntity);
        athleteEntity = athleteRepo.save(athleteEntity);
        return AthleteMapper.INSTANCE.toAthleteOutputDto(athleteEntity);
    }

    public List<AthleteOutputDto> getAthletes() {
        List<AthleteEntity> athleteEntities = athleteRepo.findAll();
        return AthleteMapper.INSTANCE.toAthleteOutputDtoList(athleteEntities);
    }

    public AthleteOutputDto getAthleteById(Long id) {
        AthleteEntity athleteEntity = athleteRepo.getById(id);
        return AthleteMapper.INSTANCE.toAthleteOutputDto(athleteEntity);
    }
}
