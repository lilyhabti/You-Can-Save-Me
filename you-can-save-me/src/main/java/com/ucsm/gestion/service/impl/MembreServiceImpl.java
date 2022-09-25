package com.ucsm.gestion.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ucsm.gestion.entities.AppRole;
import com.ucsm.gestion.entities.Membre;
import com.ucsm.gestion.exception.ResourceNotFoundException;
import com.ucsm.gestion.repositories.AppRoleRepository;
import com.ucsm.gestion.repositories.MembreRepository;
import com.ucsm.gestion.service.MembreService;

@Service
public class MembreServiceImpl implements MembreService{
	
	private MembreRepository membreRepository;
	private AppRoleRepository appRoleRepository;
//    private AppUserRepository appUserRepository;
    
	public MembreServiceImpl(MembreRepository membreRepository, AppRoleRepository appRoleRepository) {
		super();
		this.membreRepository = membreRepository;
		this.appRoleRepository = appRoleRepository;
//		this.appUserRepository = appUserRepository;
	}

	@Override
	public List<Membre> list() {
		
		return membreRepository.findAll();
	}

	@Override
	public Membre save(Membre membre) {
		
		AppRole appRole = appRoleRepository.findByRoleName("MEMBRE");
		membre.getAppRoles().add(appRole);
		return membreRepository.save(membre);
	}

	@Override
	public Membre getById(long id) {
		
		return membreRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Membre", "Id", id));
	}

	@Override
	public Membre update(Membre membre, long id) {
		
		Membre existingMembre = membreRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Membre", "Id", id));
		
		existingMembre.setNom(membre.getNom());
		existingMembre.setPrenom(membre.getPrenom());
//		String newUsername = membre.getUsername();
//		AppUser user = appUserRepository.findByUsername(newUsername);
//		if(user==null) {
//			existingMembre.setUsername(newUsername);
//		}else {
//			throw new RuntimeException("Username invalid");
//		}
		existingMembre.setUsername(membre.getUsername());
		existingMembre.setPassword(membre.getPassword());
		existingMembre.setEmail(membre.getEmail());
		existingMembre.setTelephone(membre.getTelephone());
		existingMembre.setActive(membre.isActive());
		existingMembre.setDate_entre(membre.getDate_entre());
		existingMembre.setProfession(membre.getProfession());
		existingMembre.setAge(membre.getAge());
		existingMembre.setTaches(membre.getTaches());
		
		return membreRepository.save(existingMembre);
	}

	@Override
	public void delete(long id) {
		
		membreRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Membre", "Id", id));
		
		membreRepository.deleteById(id);
	}

}
