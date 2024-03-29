package com.formation.formation_angular.services;

import com.formation.formation_angular.dto.AdherentRequestDTO;
import com.formation.formation_angular.dto.AdherentResponseDTO;
import com.formation.formation_angular.entities.Adherent;
import com.formation.formation_angular.entities.Formation;
import com.formation.formation_angular.mappers.AdherentMapper;
import com.formation.formation_angular.repositories.AdherentRepository;
import com.formation.formation_angular.repositories.FormationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdherentServiceImp implements AdherentService{
    private final AdherentRepository adherentRepository;
    private final FormationRepository formationRepository;
    @Override
    public List<AdherentResponseDTO> getAllAdherents(Long formationId) {
        List<Adherent> adherents = adherentRepository.findByFormationId(formationId);
        return adherents.stream()
                .map(AdherentMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AdherentResponseDTO getAdherentById(Long id) {
        Adherent adherent = adherentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("adherent not found with id: " + id));
        return AdherentMapper.INSTANCE.toDto(adherent);
    }

    @Override
    public void saveAdherent(Long formationId ,AdherentRequestDTO adherentRequestDTO) {
        Formation formation = formationRepository.findById(formationId)
                .orElseThrow(RuntimeException::new);
        Adherent adherent = AdherentMapper.INSTANCE.toEntity(adherentRequestDTO);
        adherent.setFormation(formation);
        adherentRepository.save(adherent);
    }

    @Override
    public void deleteAdherent(Long id) {
        if (!adherentRepository.existsById(id)) {
            throw new RuntimeException("adherent not found with id: " + id);
        }
        adherentRepository.deleteById(id);
    }

    @Override
    public void updateAdherent(Long id, AdherentRequestDTO adherentRequestDTO) {
        Optional<Adherent> optionalAdherent = adherentRepository.findById(id);
        if (optionalAdherent.isPresent()) {
            Adherent adherent = optionalAdherent.get();
            adherent.setName(adherentRequestDTO.getName());
            adherent.setContact(adherentRequestDTO.getContact());
            adherentRepository.save(adherent);
        } else {
            throw new RuntimeException("adherent not found with id: " + id);
        }
    }
}
