package com.bb.injurysurveillancesystem.mapper;

import com.bb.injurysurveillancesystem.dto.input.AthleteInputDto;
import com.bb.injurysurveillancesystem.dto.output.AthleteOutputDto;
import com.bb.injurysurveillancesystem.entity.AthleteEntity;
import com.bb.injurysurveillancesystem.entity.PhysioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AthleteMapper {
    AthleteMapper INSTANCE = Mappers.getMapper(AthleteMapper.class);

    AthleteEntity toAthleteEntity(AthleteInputDto athleteInputDto);

    @Named("toAthleteWithPyhsio")
    default AthleteEntity toAthleteEntity(AthleteInputDto athleteInputDto, PhysioEntity physioEntity) {
        AthleteEntity athleteEntity = toAthleteEntity(athleteInputDto);
        athleteEntity.setPhysioterapist(physioEntity);
        return athleteEntity;
    }

    AthleteOutputDto toAthleteOutputDto(AthleteEntity athleteEntity);

    List<AthleteOutputDto> toAthleteOutputDtoList(List<AthleteEntity> athleteEntities);
}
