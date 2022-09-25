import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Taskclass } from 'src/app/models/taskclass';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-update-task',
  templateUrl: './update-task.component.html',
  styleUrls: ['./update-task.component.css']
})
export class UpdateTaskComponent implements OnInit {

  id_task!:number;
  task:Taskclass=new Taskclass();

  constructor(private taskService : TaskService,private router:Router,private route : ActivatedRoute) { }

  ngOnInit(): void {
    this.id_task = this.route.snapshot.params['id_task'];

    this.taskService.getTaskById(this.id_task).subscribe(data => {
      this.task = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.taskService.updateTask(this.id_task,this.task).subscribe( data =>{
      this.goToTasksList();
    }
    , error => console.log(error));
  }

  goToTasksList(){
    this.router.navigate(['/tasks']);
  }
}
