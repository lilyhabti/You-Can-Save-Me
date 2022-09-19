package com.ucsm.gestion.service;

import com.ucsm.gestion.entities.Admin;
import com.ucsm.gestion.entities.AppRole;
import com.ucsm.gestion.entities.AppUser;
import com.ucsm.gestion.entities.Visiteur;

public interface AccountService {
	
	AppRole addNewRole(AppRole appRole);
	AppUser loadUserByUsername(String username);
	Admin addNewAdmin(Admin admin);
	Visiteur register(Visiteur visiteur);
}
