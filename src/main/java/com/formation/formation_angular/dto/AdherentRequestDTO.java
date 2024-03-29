package com.formation.formation_angular.dto;

import com.formation.formation_angular.entities.Formation;
import lombok.Data;

@Data
public class AdherentRequestDTO {
    private String name;
    private String contact;
    private Formation formation;
}
