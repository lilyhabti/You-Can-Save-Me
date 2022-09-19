package com.ucsm.gestion.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ucsm.gestion.entities.Animal;
import com.ucsm.gestion.exception.ResourceNotFoundException;
import com.ucsm.gestion.repositories.AnimalRepository;
import com.ucsm.gestion.service.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {
	
	private AnimalRepository animalRepository;

	public AnimalServiceImpl(AnimalRepository animalRepository) {
		super();
		this.animalRepository = animalRepository;
	}

	@Override
	public List<Animal> list() {
		
		return animalRepository.findAll();
	}

	@Override
	public Animal save(Animal animal) {
		
		return animalRepository.save(animal);
	}

	@Override
	public Animal getById(long id) {
		
		return animalRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Animal", "Id", id));
	}

	@Override
	public Animal update(Animal animal, long id) {
		
		Animal existingAnimal = animalRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Animal", "Id", id));
		
		existingAnimal.setPrenom(animal.getPrenom());
		existingAnimal.setGenre(animal.getGenre());
		existingAnimal.setDescription(animal.getDescription());
		existingAnimal.setDate_naissance(animal.getDate_naissance());
		existingAnimal.setAge(animal.getAge());
		existingAnimal.setDate_entre(animal.getDate_entre());
		existingAnimal.setVaccin(animal.isVaccin());
		existingAnimal.setSterilise(animal.isSterilise());
		existingAnimal.setTasks(animal.getTasks());
		
		return animalRepository.save(existingAnimal);
	}

	@Override
	public void delete(long id) {
		
		animalRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Animal", "Id", id));
		
		animalRepository.deleteById(id);
	}

}
