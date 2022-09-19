package com.ucsm.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucsm.gestion.entities.Membre;

public interface MembreRepository extends JpaRepository<Membre, Long> {

}
