package com.bb.injurysurveillancesystem.mapper;

import com.bb.injurysurveillancesystem.dto.input.TeamInputDto;
import com.bb.injurysurveillancesystem.dto.output.TeamOutputDto;
import com.bb.injurysurveillancesystem.entity.TeamEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TeamMapper {
    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    TeamEntity toTeamEntity(TeamInputDto inputDto);

    TeamEntity toTeamEntity(TeamOutputDto outputDto);

    TeamOutputDto toTeamOutputDtp(TeamEntity entity);

    List<TeamOutputDto> toTeamOutputDtos(List<TeamEntity> entities);
}
