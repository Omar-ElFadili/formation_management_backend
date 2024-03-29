package com.formation.formation_angular.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;


@Data
public class FormationRequestDTO {
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
}
