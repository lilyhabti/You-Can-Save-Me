import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Taskclass } from 'src/app/models/taskclass';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-tasks-list',
  templateUrl: './tasks-list.component.html',
  styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {

  tasks!:Taskclass[];

  constructor(private taskService:TaskService,private router:Router) { }

  ngOnInit(): void {
    this.getTasks();
  }

  private getTasks(){
    this.taskService.getTasksList().subscribe(data => {
      this.tasks=data;
    });
  }

  updateTask(id_task: number){
    this.router.navigate(['update-task', id_task]);
  }

  deleteTask(id_task: number){
    this.taskService.deleteTask(id_task).subscribe( data => {
      console.log(data);
      this.getTasks();
    })
  }
  taskDetails(id_task: number){
    this.router.navigate(['task-details', id_task]);
  }
}
