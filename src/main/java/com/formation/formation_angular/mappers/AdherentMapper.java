package com.formation.formation_angular.mappers;

import com.formation.formation_angular.dto.AdherentRequestDTO;
import com.formation.formation_angular.dto.AdherentResponseDTO;
import com.formation.formation_angular.dto.FormationResponseDTO;
import com.formation.formation_angular.entities.Adherent;
import com.formation.formation_angular.entities.Formation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface AdherentMapper {
    AdherentMapper INSTANCE = Mappers.getMapper(AdherentMapper.class);

    @Mapping(target = "id", ignore = true)
    Adherent toEntity(AdherentRequestDTO adherentRequestDTO);

    AdherentResponseDTO toDto(Adherent adherent);

}
