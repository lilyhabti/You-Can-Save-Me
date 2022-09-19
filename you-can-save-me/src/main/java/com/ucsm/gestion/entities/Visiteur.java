package com.ucsm.gestion.entities;


import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="visiteurs")
public class Visiteur extends AppUser {

	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date_naissance;
	private String genre;
	private String centre_interet;
	
	public Visiteur(Long id_user, String nom, String prenom, String username, String password, String email,
			String telephone, Collection<AppRole> appRoles, Date date_naissance, String genre, String centre_interet) {
		super(id_user, nom, prenom, username, password, email, telephone, appRoles);
		this.date_naissance = date_naissance;
		this.genre = genre;
		this.centre_interet = centre_interet;
	}
}
