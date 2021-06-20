package com.bb.injurysurveillancesystem.mapper;

import com.bb.injurysurveillancesystem.dto.input.PhysioInputDto;
import com.bb.injurysurveillancesystem.dto.output.PhysioOutputDto;
import com.bb.injurysurveillancesystem.entity.PhysioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PhysioMapper {
    PhysioMapper INSTANCE = Mappers.getMapper(PhysioMapper.class);

    PhysioEntity toPhysioEntity(PhysioInputDto inputDto);

    PhysioEntity toPhysioEntity(PhysioOutputDto physioOutputDto);

    PhysioOutputDto toPhysioOutputDto(PhysioEntity physioEntity);

    List<PhysioOutputDto> toPhysioOutputDtos(List<PhysioEntity> physioEntities);
}
