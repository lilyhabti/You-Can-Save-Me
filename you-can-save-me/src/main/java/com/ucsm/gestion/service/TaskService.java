package com.ucsm.gestion.service;

import java.util.List;

import com.ucsm.gestion.entities.Task;

public interface TaskService {
	
	List<Task> list();
	Task save(Task task);
	Task getById(long id);
	Task update(Task task,long id);
	void delete(long id);


}
