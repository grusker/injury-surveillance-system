package com.bb.injurysurveillancesystem.service;

import com.bb.injurysurveillancesystem.dto.input.AthleteInputDto;
import com.bb.injurysurveillancesystem.dto.output.AthleteOutputDto;
import com.bb.injurysurveillancesystem.dto.output.PhysioOutputDto;
import com.bb.injurysurveillancesystem.entity.AthleteEntity;
import com.bb.injurysurveillancesystem.entity.BodyInfoEntity;
import com.bb.injurysurveillancesystem.entity.PhysioEntity;
import com.bb.injurysurveillancesystem.entity.SportInfoEntity;
import com.bb.injurysurveillancesystem.mapper.AthleteMapper;
import com.bb.injurysurveillancesystem.mapper.PhysioMapper;
import com.bb.injurysurveillancesystem.repository.AthleteRepository;
import com.bb.injurysurveillancesystem.repository.BodyInfoRepository;
import com.bb.injurysurveillancesystem.repository.SportInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AthleteService {
    @Autowired
    private AthleteRepository athleteRepo;
    @Autowired
    private SportInfoRepository sportInfoRepo;
    @Autowired
    private BodyInfoRepository bodyInfoRepo;
    @Autowired
    private PhysioService physioService;

    @Transactional
    public AthleteOutputDto createAthlete(AthleteInputDto inputDto) {
        PhysioOutputDto physioOutputDto = physioService.getPhysioById(inputDto.getPhysioId());
        PhysioEntity physioEntity = PhysioMapper.INSTANCE.toPhysioEntity(physioOutputDto);
        AthleteEntity athleteEntity = AthleteMapper.INSTANCE.toAthleteEntity(inputDto, physioEntity);
        athleteEntity = athleteRepo.save(athleteEntity);

        SportInfoEntity sportInfoEntity = AthleteMapper.INSTANCE.toSportInfoEntity(inputDto);
        sportInfoEntity.setAthlete(athleteEntity);
        sportInfoRepo.save(sportInfoEntity);

        BodyInfoEntity bodyInfoEntity = AthleteMapper.INSTANCE.toBodyInfoEntity(inputDto);
        bodyInfoEntity.setAthlete(athleteEntity);
        bodyInfoRepo.save(bodyInfoEntity);
        return AthleteMapper.INSTANCE.toAthleteOutputDto(athleteEntity, sportInfoEntity, bodyInfoEntity);
    }

    public List<AthleteOutputDto> getAthletes() {
        List<AthleteEntity> athleteEntities = athleteRepo.findAll();
        List<SportInfoEntity> sportInfoEntities = sportInfoRepo.findAll();
        List<BodyInfoEntity> bodyInfoEntities = bodyInfoRepo.findAll();

        return AthleteMapper.INSTANCE.toAthleteOutputDtoList(athleteEntities, sportInfoEntities, bodyInfoEntities);
    }

    public AthleteOutputDto getAthleteById(Long id) {
        AthleteEntity athleteEntity = athleteRepo.getById(id);
        SportInfoEntity sportInfoEntity = sportInfoRepo.getById(id);
        BodyInfoEntity bodyInfoEntity = bodyInfoRepo.getById(id);

        return AthleteMapper.INSTANCE.toAthleteOutputDto(athleteEntity, sportInfoEntity, bodyInfoEntity);
    }
}
