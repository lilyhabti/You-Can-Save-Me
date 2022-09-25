import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Taskclass } from 'src/app/models/taskclass';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-task-details',
  templateUrl: './task-details.component.html',
  styleUrls: ['./task-details.component.css']
})
export class TaskDetailsComponent implements OnInit {

  id_task!:number;
  task!:Taskclass;

  constructor(private taskService:TaskService,private route : ActivatedRoute) { }

  ngOnInit(): void {
    this.id_task = this.route.snapshot.params['id_task'];

    this.task = new Taskclass();
    this.taskService.getTaskById(this.id_task).subscribe( data => {
      this.task = data;
    });
  }

}
