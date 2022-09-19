package com.ucsm.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucsm.gestion.entities.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{

}
