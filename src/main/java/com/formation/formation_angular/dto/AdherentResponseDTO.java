package com.formation.formation_angular.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.formation.formation_angular.entities.Formation;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class AdherentResponseDTO {
    private Long id;
    private String name;
    private String contact;
    @JsonIgnore
    private Formation formation;
}
