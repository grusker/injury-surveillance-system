package com.bb.injurysurveillancesystem.mapper;

import com.bb.injurysurveillancesystem.dto.input.AthleteInputDto;
import com.bb.injurysurveillancesystem.dto.input.PhysioInputDto;
import com.bb.injurysurveillancesystem.dto.output.PhysioOutputDto;
import com.bb.injurysurveillancesystem.entity.PhysioEntity;
import com.bb.injurysurveillancesystem.entity.SportInfoEntity;
import com.bb.injurysurveillancesystem.entity.TeamEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PhysioMapper {
    PhysioMapper INSTANCE = Mappers.getMapper(PhysioMapper.class);

    PhysioEntity toPhysioEntity(PhysioInputDto inputDto);

    PhysioEntity toPhysioEntity(PhysioOutputDto physioOutputDto);

    PhysioOutputDto toPhysioOutputDto(PhysioEntity physioEntity);

    List<PhysioOutputDto> toPhysioOutputDtos(List<PhysioEntity> physioEntities);

    @Named("toPhysioEntityWithTeam")
    default PhysioEntity toPhysioEntity(PhysioInputDto physioInputDto, TeamEntity teamEntity) {
        PhysioEntity physioEntity = toPhysioEntity(physioInputDto);
        physioEntity.setTeam(teamEntity);
        return physioEntity;
    }
}
