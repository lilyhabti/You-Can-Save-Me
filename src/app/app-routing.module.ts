import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnimalDetailsComponent } from './animal/animal-details/animal-details.component';
import { AnimalsListComponent } from './animal/animals-list/animals-list.component';
import { CreateAnimalComponent } from './animal/create-animal/create-animal.component';
import { UpdateAnimalComponent } from './animal/update-animal/update-animal.component';
import { CreateMembreComponent } from './membre/create-membre/create-membre.component';
import { MembreDetailsComponent } from './membre/membre-details/membre-details.component';
import { MembresListComponent } from './membre/membres-list/membres-list.component';
import { UpdateMembreComponent } from './membre/update-membre/update-membre.component';
import { CreateTaskComponent } from './tasks/create-task/create-task.component';
import { TaskDetailsComponent } from './tasks/task-details/task-details.component';
import { TasksListComponent } from './tasks/tasks-list/tasks-list.component';
import { UpdateTaskComponent } from './tasks/update-task/update-task.component';

const routes: Routes = [
  {path:'membres',component:MembresListComponent},
  {path:'create-membre',component:CreateMembreComponent},
  {path:'update-membre/:id_user',component:UpdateMembreComponent},
  {path:'animals',component:AnimalsListComponent},
  {path : 'create-animal',component:CreateAnimalComponent},
  {path:'update-animal/:id_animal',component:UpdateAnimalComponent},
  {path:'animal-details/:id_animal',component:AnimalDetailsComponent},
  {path:'membre-details/:id_user',component:MembreDetailsComponent},
  {path:'tasks',component:TasksListComponent},
  {path:'create-task',component:CreateTaskComponent},
  {path:'update-task/:id_task',component:UpdateTaskComponent},
  {path:'task-details/:id_task',component:TaskDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
