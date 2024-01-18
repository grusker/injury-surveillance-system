package com.bb.injurysurveillancesystem.service;

import com.bb.injurysurveillancesystem.dto.input.AthleteInputDto;
import com.bb.injurysurveillancesystem.dto.output.AthleteOutputDto;
import com.bb.injurysurveillancesystem.dto.output.TeamOutputDto;
import com.bb.injurysurveillancesystem.entity.*;
import com.bb.injurysurveillancesystem.mapper.AthleteMapper;
import com.bb.injurysurveillancesystem.mapper.TeamMapper;
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
    private TeamService teamService;

    @Transactional
    public AthleteOutputDto createAthlete(AthleteInputDto inputDto) {
        AthleteEntity athleteEntity = AthleteMapper.INSTANCE.toAthleteEntity(inputDto);
        athleteEntity = athleteRepo.save(athleteEntity);

        TeamOutputDto teamOutputDto = teamService.getTeamById(inputDto.getSportInfo().getTeamId());
        TeamEntity teamEntity = TeamMapper.INSTANCE.toTeamEntity(teamOutputDto);
        SportInfoEntity sportInfoEntity = AthleteMapper.INSTANCE.toSportInfoEntity(inputDto, teamEntity);
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

    public AthleteOutputDto updateAthlete(Long id, AthleteInputDto inputDto) {
        TeamOutputDto teamOutputDto = teamService.getTeamById(inputDto.getSportInfo().getTeamId());
        TeamEntity teamEntity = TeamMapper.INSTANCE.toTeamEntity(teamOutputDto);
        AthleteEntity athleteEntity = AthleteMapper.INSTANCE.toAthleteEntity(inputDto);
        SportInfoEntity sportInfoEntity = AthleteMapper.INSTANCE.toSportInfoEntity(inputDto, teamEntity);
        BodyInfoEntity bodyInfoEntity = AthleteMapper.INSTANCE.toBodyInfoEntity(inputDto);

        athleteEntity.setId(id);
        sportInfoEntity.setId(id);
        bodyInfoEntity.setId(id);

        athleteRepo.save(athleteEntity);
        sportInfoRepo.save(sportInfoEntity);
        bodyInfoRepo.save(bodyInfoEntity);

        return AthleteMapper.INSTANCE.toAthleteOutputDto(athleteEntity, sportInfoEntity, bodyInfoEntity);
    }
}
