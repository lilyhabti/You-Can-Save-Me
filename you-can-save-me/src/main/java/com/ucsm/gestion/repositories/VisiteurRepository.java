package com.ucsm.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucsm.gestion.entities.Visiteur;

public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {

}
