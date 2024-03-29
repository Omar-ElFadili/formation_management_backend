package com.formation.formation_angular.services;

import com.formation.formation_angular.dto.FormationRequestDTO;
import com.formation.formation_angular.dto.FormationResponseDTO;
import com.formation.formation_angular.entities.Formation;
import com.formation.formation_angular.mappers.FormationMapper;
import com.formation.formation_angular.repositories.FormationRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.codec.FormHttpMessageReader;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FormationServiceImp implements FormationService{
    private final FormationRepository formationRepository;


    @Override
    public List<FormationResponseDTO> getAllFormations() {
        List<Formation> formations = formationRepository.findAll();
        return formations.stream()
                .map(FormationMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FormationResponseDTO getFormationById(Long id) {
        Formation formation = formationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("formation not found with id: " + id));
        return FormationMapper.INSTANCE.toDto(formation);
    }

    @Override
    public void saveFormation(FormationRequestDTO formationRequestDTO) {
        Formation formation = FormationMapper.INSTANCE.toEntity(formationRequestDTO);
        formationRepository.save(formation);
    }

    @Override
    public void deleteFormation(Long id) {
        if (!formationRepository.existsById(id)) {
            throw new RuntimeException("formation not found with id: " + id);
        }
        formationRepository.deleteById(id);
    }

    @Override
    public void updateFormation(Long id, FormationRequestDTO formationRequestDTO) {
        Optional<Formation> optionalFormation = formationRepository.findById(id);
        if (optionalFormation.isPresent()) {
            Formation formation = optionalFormation.get();
            formation.setTitle(formationRequestDTO.getTitle());
            formation.setDescription(formationRequestDTO.getDescription());
            formation.setEndDate(formationRequestDTO.getEndDate());
            formation.setStartDate(formationRequestDTO.getStartDate());
            formationRepository.save(formation);
        } else {
            throw new RuntimeException("formation not found with id: " + id);
        }
    }
}
