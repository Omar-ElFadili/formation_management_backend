package com.formation.formation_angular.mappers;

import com.formation.formation_angular.dto.FormationRequestDTO;
import com.formation.formation_angular.dto.FormationResponseDTO;
import com.formation.formation_angular.entities.Formation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FormationMapper {
    FormationMapper INSTANCE = Mappers.getMapper(FormationMapper.class);

    @Mapping(target = "id", ignore = true)
    Formation toEntity(FormationRequestDTO formationRequestDTO);

    FormationResponseDTO toDto(Formation formation);

    @Mapping(target = "id", ignore = true)
    Formation toEntity(FormationResponseDTO formationResponseDTO);

    @Mapping(target = "id", ignore = true)
    FormationResponseDTO toResponseDto(Formation formation);
}