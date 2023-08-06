package com.bb.injurysurveillancesystem.mapper;

import com.bb.injurysurveillancesystem.dto.input.AthleteInputDto;
import com.bb.injurysurveillancesystem.dto.input.BodyInfoInputDto;
import com.bb.injurysurveillancesystem.dto.input.SportInfoInputDto;
import com.bb.injurysurveillancesystem.dto.output.AthleteOutputDto;
import com.bb.injurysurveillancesystem.entity.AthleteEntity;
import com.bb.injurysurveillancesystem.entity.BodyInfoEntity;
import com.bb.injurysurveillancesystem.entity.PhysioEntity;
import com.bb.injurysurveillancesystem.entity.SportInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AthleteMapper {
    AthleteMapper INSTANCE = Mappers.getMapper(AthleteMapper.class);

    AthleteEntity toAthleteEntity(AthleteInputDto athleteInputDto);
    SportInfoEntity toSportInfoEntity(SportInfoInputDto sportInfoInputDto);
    BodyInfoEntity toBodyInfoEntity(BodyInfoInputDto bodyInfoInputDto);

    @Named("toAthleteWithPyhsio")
    default AthleteEntity toAthleteEntity(AthleteInputDto athleteInputDto, PhysioEntity physioEntity) {
        AthleteEntity athleteEntity = toAthleteEntity(athleteInputDto);
        athleteEntity.setPhysiotherapist(physioEntity);
        return athleteEntity;
    }

    @Named("toSportInfoFromAthlete")
    default SportInfoEntity toSportInfoEntity(AthleteInputDto athleteInputDto) {
        return toSportInfoEntity(athleteInputDto.getSportInfo());
    }

    @Named("toBodyInfoFromAthlete")
    default BodyInfoEntity toBodyInfoEntity(AthleteInputDto athleteInputDto) {
        return toBodyInfoEntity(athleteInputDto.getBodyInfo());
    }

    AthleteOutputDto toAthleteOutputDto(AthleteEntity athleteEntity);

    List<AthleteOutputDto> toAthleteOutputDtoList(List<AthleteEntity> athleteEntities);
}
