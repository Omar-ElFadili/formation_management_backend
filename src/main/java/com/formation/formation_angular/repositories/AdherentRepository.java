package com.formation.formation_angular.repositories;

import com.formation.formation_angular.entities.Adherent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdherentRepository extends JpaRepository<Adherent, Long> {
    List<Adherent> findByFormationId(Long formationId);
}
