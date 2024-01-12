package com.bb.injurysurveillancesystem.service;

import com.bb.injurysurveillancesystem.dto.input.TeamInputDto;
import com.bb.injurysurveillancesystem.dto.output.TeamOutputDto;
import com.bb.injurysurveillancesystem.entity.TeamEntity;
import com.bb.injurysurveillancesystem.mapper.TeamMapper;
import com.bb.injurysurveillancesystem.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepo;

    public TeamOutputDto createTeam(TeamInputDto teamInputDto) {
        TeamEntity entity = TeamMapper.INSTANCE.toTeamEntity(teamInputDto);
        entity = teamRepo.save(entity);
        return TeamMapper.INSTANCE.toTeamOutputDtp(entity);
    }

    public List<TeamOutputDto> getTeams() {
        List<TeamEntity> teamEntities = teamRepo.findAll();
        return TeamMapper.INSTANCE.toTeamOutputDtos(teamEntities);
    }

    public TeamOutputDto getTeamById(Long id) {
        TeamEntity teamEntity = teamRepo.getById(id);
        return TeamMapper.INSTANCE.toTeamOutputDtp(teamEntity);
    }

    public TeamOutputDto updateTeam(Long id, TeamInputDto updatedTeam) {
        TeamEntity entity = TeamMapper.INSTANCE.toTeamEntity(updatedTeam);
        entity.setId(id);
        entity = teamRepo.save(entity);
        return TeamMapper.INSTANCE.toTeamOutputDtp(entity);
    }
}
