package com.formation.formation_angular.services;

import com.formation.formation_angular.dto.FormationRequestDTO;
import com.formation.formation_angular.dto.FormationResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FormationService {
    public List<FormationResponseDTO> getAllFormations();

    public FormationResponseDTO getFormationById(Long id);

    public void saveFormation(FormationRequestDTO formationRequestDTO);

    public void deleteFormation(Long id);

    void updateFormation(Long id, FormationRequestDTO formationRequestDTO);
}
