package com.ucsm.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucsm.gestion.entities.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
	
	AppRole findByRoleName(String roleName);

}
