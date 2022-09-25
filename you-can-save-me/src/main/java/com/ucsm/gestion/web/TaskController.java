package com.ucsm.gestion.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ucsm.gestion.entities.Task;
import com.ucsm.gestion.service.TaskService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {
	
	private TaskService taskService;

	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}
	
	@PostMapping(path = "/tasks")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Task> save(@RequestBody Task task){
		return new ResponseEntity<Task>(taskService.save(task), HttpStatus.CREATED);
	}

	@GetMapping(path="/tasks")
//	@PostAuthorize("hasAuthority('ADMIN','CLIENT')")
	public List<Task> getAll(){
		
		return taskService.list();
	}
	@GetMapping(path="/tasks/{id_task}")
//	@PostAuthorize("hasAuthority('ADMIN','CLIENT')")
	public ResponseEntity<Task> getById(@PathVariable("id_task") long id){
		return new ResponseEntity<Task>(taskService.getById(id), HttpStatus.OK);
	}
	
	@PutMapping(path="/tasks/{id_task}")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Task> update(@PathVariable("id_task") long id ,@RequestBody Task task){
		return new ResponseEntity<Task>(taskService.update(task, id), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/tasks/{id_task}")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<String> delete(@PathVariable("id_task") long id){
		taskService.delete(id);
			
		return new ResponseEntity<String>("Task deleted successfully!.", HttpStatus.OK);
	}
}
