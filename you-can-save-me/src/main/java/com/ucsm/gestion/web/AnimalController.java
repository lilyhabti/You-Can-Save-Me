package com.ucsm.gestion.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ucsm.gestion.entities.Animal;
import com.ucsm.gestion.service.AnimalService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AnimalController {
	
	private AnimalService animalService;

	public AnimalController(AnimalService animalService) {
		super();
		this.animalService = animalService;
	}
	
	@PostMapping(path = "/animals")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Animal> save(@RequestBody Animal animal){
		return new ResponseEntity<Animal>(animalService.save(animal), HttpStatus.CREATED);
	}

	@GetMapping(path="/animals")
//	@PostAuthorize("hasAuthority('ADMIN','CLIENT')")
	public List<Animal> getAll(){
		
		return animalService.list();
	}
	
	@GetMapping(path="/animals/{id_animal}")
//	@PostAuthorize("hasAuthority('ADMIN','CLIENT')")
	public ResponseEntity<Animal> getById(@PathVariable("id_animal") long id){
		return new ResponseEntity<Animal>(animalService.getById(id), HttpStatus.OK);
	}
	
	@PutMapping(path="/animals/{id_animal}")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Animal> update(@PathVariable("id_animal") long id ,@RequestBody Animal animal){
		return new ResponseEntity<Animal>(animalService.update(animal, id), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/animals/{id_animal}")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<String> delete(@PathVariable("id_animal") long id){
		
		animalService.delete(id);
			
		return new ResponseEntity<String>("Animal deleted successfully!.", HttpStatus.OK);
	}

}
