package com.formation.formation_angular.controllers;

import com.formation.formation_angular.dto.AdherentRequestDTO;
import com.formation.formation_angular.dto.AdherentResponseDTO;
import com.formation.formation_angular.services.AdherentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/formations")
public class AdherentController {
    private final AdherentService adherentService;

    @GetMapping("/{id}/adherent")
    public ResponseEntity<List<AdherentResponseDTO>> getAllAdherent(@PathVariable Long id) {
        List<AdherentResponseDTO> adherents = adherentService.getAllAdherents(id);
        return ResponseEntity.ok(adherents);
    }

    @GetMapping("/{id1}/adherent/{id2}")
    public ResponseEntity<AdherentResponseDTO> getAdherentById(@PathVariable Long id1, @PathVariable Long id2) {
        AdherentResponseDTO adherent = adherentService.getAdherentById(id2);
        if (adherent != null) {
            return ResponseEntity.ok(adherent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/adherent")
    public ResponseEntity<String> createAdherent(@PathVariable Long id,@RequestBody AdherentRequestDTO adherentRequestDTO) {
        adherentService.saveAdherent(id,adherentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("this adherent has been created");
    }

    @PutMapping("/{id1}/adherent/{id2}")
    public ResponseEntity<String> updateAdherent(@PathVariable Long id1, @PathVariable Long id2, @RequestBody AdherentRequestDTO adherentRequestDTO) {
        adherentService.updateAdherent(id2, adherentRequestDTO);
        return ResponseEntity.ok("adherent has been updated");
    }

    @DeleteMapping("/{id1}/adherent/{id2}")
    public ResponseEntity<String> deleteAdherent(@PathVariable Long id1, @PathVariable Long id2) {
        adherentService.deleteAdherent(id2);
        return ResponseEntity.ok("adherent has been deleted");
    }
}
