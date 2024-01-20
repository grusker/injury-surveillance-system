package com.bb.injurysurveillancesystem.service;

import com.bb.injurysurveillancesystem.dto.input.PhysioInputDto;
import com.bb.injurysurveillancesystem.dto.output.PhysioOutputDto;
import com.bb.injurysurveillancesystem.dto.output.TeamOutputDto;
import com.bb.injurysurveillancesystem.entity.PhysioEntity;
import com.bb.injurysurveillancesystem.entity.TeamEntity;
import com.bb.injurysurveillancesystem.mapper.PhysioMapper;
import com.bb.injurysurveillancesystem.mapper.TeamMapper;
import com.bb.injurysurveillancesystem.repository.PhysioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhysioService {
    @Autowired
    private PhysioRepository physioRepo;

    @Autowired
    private TeamService teamService;

    public PhysioOutputDto createPhysio(PhysioInputDto physioInputDto) {
        TeamOutputDto teamOutputDto = teamService.getTeamById(physioInputDto.getTeamId());
        TeamEntity teamEntity = TeamMapper.INSTANCE.toTeamEntity(teamOutputDto);
        PhysioEntity entity = PhysioMapper.INSTANCE.toPhysioEntity(physioInputDto, teamEntity);
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

    public PhysioOutputDto updatePhysio(Long id, PhysioInputDto updatedPhysio) {
        TeamOutputDto teamOutputDto = teamService.getTeamById(updatedPhysio.getTeamId());
        TeamEntity teamEntity = TeamMapper.INSTANCE.toTeamEntity(teamOutputDto);
        PhysioEntity entity = PhysioMapper.INSTANCE.toPhysioEntity(updatedPhysio, teamEntity);
        entity.setId(id);
        entity = physioRepo.save(entity);
        return PhysioMapper.INSTANCE.toPhysioOutputDto(entity);
    }
}
