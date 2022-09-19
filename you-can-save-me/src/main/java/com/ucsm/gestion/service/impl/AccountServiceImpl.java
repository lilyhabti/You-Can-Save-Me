package com.ucsm.gestion.service.impl;

import org.springframework.stereotype.Service;

import com.ucsm.gestion.entities.Admin;
import com.ucsm.gestion.entities.AppRole;
import com.ucsm.gestion.entities.AppUser;
import com.ucsm.gestion.entities.Visiteur;
import com.ucsm.gestion.repositories.AdminRepository;
import com.ucsm.gestion.repositories.AppRoleRepository;
import com.ucsm.gestion.repositories.AppUserRepository;
import com.ucsm.gestion.repositories.VisiteurRepository;
import com.ucsm.gestion.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	private AppRoleRepository appRoleRepository;
	private AppUserRepository appUserRepository;
	private AdminRepository adminRepository;
	private VisiteurRepository visiteurRepository;
	
	public AccountServiceImpl(AppRoleRepository appRoleRepository, AppUserRepository appUserRepository,
			AdminRepository adminRepository, VisiteurRepository visiteurRepository) {
		super();
		this.appRoleRepository = appRoleRepository;
		this.appUserRepository = appUserRepository;
		this.adminRepository = adminRepository;
		this.visiteurRepository = visiteurRepository;
	}

	@Override
	public AppRole addNewRole(AppRole appRole) {
		
		return appRoleRepository.save(appRole);
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		
		return appUserRepository.findByUsername(username);
	}

	@Override
	public Admin addNewAdmin(Admin admin) {
		
		AppRole appRole = appRoleRepository.findByRoleName("ADMIN");
		admin.getAppRoles().add(appRole);
		return adminRepository.save(admin);
	}

	@Override
	public Visiteur register(Visiteur visiteur) {
		
		String username = visiteur.getUsername();
		AppUser user= appUserRepository.findByUsername(username);
		if(user==null) {
			AppRole appRole = appRoleRepository.findByRoleName("VISITEUR");
			visiteur.getAppRoles().add(appRole);
			return visiteurRepository.save(visiteur);
		}else {
            
			throw new RuntimeException("Username invalid");
		}
	}

}
