package com.ucsm.gestion.service;

import java.util.List;

import com.ucsm.gestion.entities.Membre;

public interface MembreService {
	
	List<Membre> list();
	Membre save(Membre membre);
	Membre getById(long id);
	Membre update(Membre membre,long id);
	void delete(long id);

}
