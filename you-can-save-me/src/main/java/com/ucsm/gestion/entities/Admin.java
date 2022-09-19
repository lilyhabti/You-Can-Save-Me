package com.ucsm.gestion.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="admins")
public class Admin extends AppUser {
	
	private boolean active;

	public Admin(Long id_user, String nom, String prenom, String username, String password, String email,
			String telephone, Collection<AppRole> appRoles, boolean active) {
		super(id_user, nom, prenom, username, password, email, telephone, appRoles);
		this.active = active;
	}
}
