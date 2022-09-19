package com.ucsm.gestion.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ucsm.gestion.entities.Admin;
import com.ucsm.gestion.entities.AppRole;
import com.ucsm.gestion.entities.Visiteur;
import com.ucsm.gestion.service.AccountService;

@RestController
public class AccountRestController {
	
	private AccountService accountService;

	public AccountRestController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@PostMapping(path = "/addAdmin")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public Admin saveUser(@RequestBody Admin admin) {
		
		return accountService.addNewAdmin(admin);
	}
	
	@PostMapping(path = "/register")
	public String ragister(@RequestBody Visiteur visiteur) {
		
		accountService.register(visiteur);

		return "Registered Successufully!";
	}
	
	@PostMapping(path = "/roles")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public AppRole saveRole(@RequestBody AppRole appRole) {
		
		return accountService.addNewRole(appRole);
	}

}
