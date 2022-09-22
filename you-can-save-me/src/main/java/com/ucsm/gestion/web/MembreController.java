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

import com.ucsm.gestion.entities.Membre;
import com.ucsm.gestion.service.MembreService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MembreController {
	
	private MembreService membreService;

	public MembreController(MembreService membreService) {
		super();
		this.membreService = membreService;
	}
	
	@PostMapping(path = "/membres")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Membre> save(@RequestBody Membre membre){
		return new ResponseEntity<Membre>(membreService.save(membre), HttpStatus.CREATED);
	}

	@GetMapping(path="/membres")
//	@PostAuthorize("hasAuthority('ADMIN','CLIENT')")
	public List<Membre> getAll(){
		
		return membreService.list();
	}
	
	@GetMapping(path="/membres/{id_user}")
//	@PostAuthorize("hasAuthority('ADMIN','CLIENT')")
	public ResponseEntity<Membre> getById(@PathVariable("id_user") long id){
		return new ResponseEntity<Membre>(membreService.getById(id), HttpStatus.OK);
	}
	
	@PutMapping(path="/membres/{id_user}")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Membre> update(@PathVariable("id_user") long id ,@RequestBody Membre membre){
		return new ResponseEntity<Membre>(membreService.update(membre, id), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/membres/{id_user}")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<String> delete(@PathVariable("id") long id){
		membreService.delete(id);
			
		return new ResponseEntity<String>("Membre deleted successfully!.", HttpStatus.OK);
	}
}
