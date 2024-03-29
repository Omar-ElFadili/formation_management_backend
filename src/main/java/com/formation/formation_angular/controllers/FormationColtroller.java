package com.formation.formation_angular.controllers;

import com.formation.formation_angular.dto.FormationRequestDTO;
import com.formation.formation_angular.dto.FormationResponseDTO;
import com.formation.formation_angular.entities.Formation;
import com.formation.formation_angular.services.FormationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/formation")
public class FormationColtroller{
    private final FormationService formationService;

    @GetMapping
    public ResponseEntity<List<FormationResponseDTO>> getAllFormations() {
        List<FormationResponseDTO> formations = formationService.getAllFormations();
        return ResponseEntity.ok(formations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormationResponseDTO> getFormationById(@PathVariable Long id) {
        FormationResponseDTO formation = formationService.getFormationById(id);
        if (formation != null) {
            return ResponseEntity.ok(formation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createFormation(@RequestBody FormationRequestDTO formationRequestDTO) {
        formationService.saveFormation(formationRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("this formation has been created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFormation(@PathVariable Long id, @RequestBody FormationRequestDTO formationRequestDTO) {
        formationService.updateFormation(id, formationRequestDTO);
        return ResponseEntity.ok("formation has been updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFormation(@PathVariable Long id) {
        formationService.deleteFormation(id);
        return ResponseEntity.ok("formation has been deleted");
    }

}
