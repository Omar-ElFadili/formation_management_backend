package com.formation.formation_angular.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    @OneToMany(mappedBy = "formation" , cascade = CascadeType.ALL)
    private List<Adherent> adherents;
}
