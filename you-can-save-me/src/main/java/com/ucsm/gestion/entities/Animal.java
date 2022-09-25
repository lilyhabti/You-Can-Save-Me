package com.ucsm.gestion.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="animals")
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_animal;
	private String prenom;
	private String genre;
	private String description;
//	@JsonFormat(pattern="yyyy-MM-dd")
//	@Temporal(TemporalType.DATE)
//	private Date date_naissance;
	private int age;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date_entre;
	private boolean vaccin;
	private boolean sterilise;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "animal_task",joinColumns = @JoinColumn(name = "id_animal"),inverseJoinColumns = @JoinColumn(name = "id_task"))
    private Collection<Task> tasks = new ArrayList<>();
}
