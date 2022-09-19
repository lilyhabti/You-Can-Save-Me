package com.ucsm.gestion.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ucsm.gestion.entities.Task;
import com.ucsm.gestion.exception.ResourceNotFoundException;
import com.ucsm.gestion.repositories.TaskRepository;
import com.ucsm.gestion.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	private TaskRepository taskRepository;

	public TaskServiceImpl(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}

	@Override
	public List<Task> list() {

		return taskRepository.findAll();
	}

	@Override
	public Task save(Task task) {
		
		return taskRepository.save(task);
	}

	@Override
	public Task getById(long id) {
		
		return taskRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Task", "Id", id));
	}

	@Override
	public Task update(Task task, long id) {
		
		Task existingTask = taskRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Task", "Id", id));
		
		existingTask.setTitre(task.getTitre());
		existingTask.setDescriptif(task.getDescriptif());
		existingTask.setType(task.getType());
		existingTask.setDate_debut(task.getDate_debut());
		existingTask.setDate_fin(task.getDate_fin());
		existingTask.setStatut(task.getStatut());
		existingTask.setPosts(task.getPosts());
		existingTask.setMembre(task.getMembre());
		
		return taskRepository.save(existingTask);
	}

	@Override
	public void delete(long id) {
		
		taskRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Task", "Id", id));
		
		taskRepository.deleteById(id);
	}

}
