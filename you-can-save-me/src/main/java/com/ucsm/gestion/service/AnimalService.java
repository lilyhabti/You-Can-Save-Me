package com.ucsm.gestion.service;

import java.util.List;

import com.ucsm.gestion.entities.Animal;

public interface AnimalService {
	
	List<Animal> list();
	Animal save(Animal animal);
	Animal getById(long id);
	Animal update(Animal animal,long id);
	void delete(long id);

}
