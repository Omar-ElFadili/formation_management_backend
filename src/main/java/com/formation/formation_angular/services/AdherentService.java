package com.formation.formation_angular.services;

import com.formation.formation_angular.dto.AdherentRequestDTO;
import com.formation.formation_angular.dto.AdherentResponseDTO;
import com.formation.formation_angular.entities.Adherent;
import com.formation.formation_angular.mappers.AdherentMapper;
import com.formation.formation_angular.mappers.FormationMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface AdherentService {
    public List<AdherentResponseDTO> getAllAdherents(Long id);
    public AdherentResponseDTO getAdherentById(Long id);
    public void saveAdherent(Long formationId ,AdherentRequestDTO adherentRequestDTO);
    public void deleteAdherent(Long id);
    public void updateAdherent(Long id, AdherentRequestDTO adherentRequestDTO);
}
