package com.ucsm.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucsm.gestion.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
