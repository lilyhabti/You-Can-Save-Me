package com.ucsm.gestion.entities;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="membres")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class, 
        property = "id_user")
public class Membre extends AppUser{

	private boolean active;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date_entre;
	private String profession;
	private int age;
	
//	@JsonIgnore
	@OneToMany(mappedBy = "membre")
    private Collection<Task> taches = new ArrayList<>();
	
//	public void addTask(Task task) {
//		taches.add(task);
//		task.setMembre(this);
//    }
// 
//    public void removeTask(Task task) {
//    	taches.remove(task);
//    	task.setMembre(null);;
//    }

	public Membre(Long id_user, String nom, String prenom, String username, String password, String email,
			String telephone, Collection<AppRole> appRoles, boolean active, Date date_entre, String profession, int age,
			List<Task> taches) {
		super(id_user, nom, prenom, username, password, email, telephone, appRoles);
		this.active = active;
		this.date_entre = date_entre;
		this.profession = profession;
		this.age = age;
		this.taches = taches;
	}
}
