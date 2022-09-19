package com.ucsm.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucsm.gestion.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
