package com.bb.injurysurveillancesystem.mapper;

import com.bb.injurysurveillancesystem.dto.input.AthleteInputDto;
import com.bb.injurysurveillancesystem.dto.input.BodyInfoInputDto;
import com.bb.injurysurveillancesystem.dto.input.SportInfoInputDto;
import com.bb.injurysurveillancesystem.dto.output.AthleteOutputDto;
import com.bb.injurysurveillancesystem.dto.output.BodyInfoOutputDto;
import com.bb.injurysurveillancesystem.dto.output.SportInfoOutputDto;
import com.bb.injurysurveillancesystem.entity.*;
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
    AthleteOutputDto toAthleteOutputDto(AthleteEntity athleteEntity);
    List<AthleteOutputDto> toAthleteOutputDtoList(List<AthleteEntity> athleteEntityList);
    SportInfoOutputDto toSportInfoOutputDto(SportInfoEntity sportInfoEntity);
    BodyInfoOutputDto toBodyInfoOutputDto(BodyInfoEntity bodyInfoEntity);

    @Named("toSportInfoWithTeamFromAthlete")
    default SportInfoEntity toSportInfoEntity(AthleteInputDto athleteInputDto, TeamEntity teamEntity) {
        SportInfoEntity sportInfoEntity = toSportInfoEntity(athleteInputDto.getSportInfo());
        sportInfoEntity.setTeam(teamEntity);
        return sportInfoEntity;
    }

    @Named("toBodyInfoFromAthlete")
    default BodyInfoEntity toBodyInfoEntity(AthleteInputDto athleteInputDto) {
        return toBodyInfoEntity(athleteInputDto.getBodyInfo());
    }

    @Named("toAthleteOutputDtoListWithFullInfo")
    default List<AthleteOutputDto> toAthleteOutputDtoList(
            List<AthleteEntity> athleteEntities,
            List<SportInfoEntity> sportInfoEntities,
            List<BodyInfoEntity> bodyInfoEntities) {
        List<AthleteOutputDto> athleteOutputDtoList = toAthleteOutputDtoList(athleteEntities);

        return athleteOutputDtoList.stream().map(
                athleteOutputDto -> {
                    Long id = athleteOutputDto.getId();
                    SportInfoEntity sportInfoEntity = sportInfoEntities.stream().filter(s -> s.getId().equals(id)).findFirst().get();
                    SportInfoOutputDto sportInfoOutputDto = toSportInfoOutputDto(sportInfoEntity);
                    athleteOutputDto.setSportInfo(sportInfoOutputDto);
                    BodyInfoEntity bodyInfoEntity = bodyInfoEntities.stream().filter(s -> s.getId().equals(id)).findFirst().get();
                    BodyInfoOutputDto bodyInfoOutputDto = toBodyInfoOutputDto(bodyInfoEntity);
                    athleteOutputDto.setBodyInfo(bodyInfoOutputDto);
                    return athleteOutputDto;
                }
        ).toList();
    }

    @Named("toAthleteOutputDtoWithFullInfo")
    default AthleteOutputDto toAthleteOutputDto(AthleteEntity athleteEntity, SportInfoEntity sportInfoEntity, BodyInfoEntity bodyInfoEntity) {
        AthleteOutputDto athleteOutputDto = toAthleteOutputDto(athleteEntity);
        athleteOutputDto.setSportInfo(toSportInfoOutputDto(sportInfoEntity));
        athleteOutputDto.setBodyInfo(toBodyInfoOutputDto(bodyInfoEntity));
        return athleteOutputDto;
    }
}
