import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MembresListComponent } from './membre/membres-list/membres-list.component';
import { CreateMembreComponent } from './membre/create-membre/create-membre.component';
import { UpdateMembreComponent } from './membre/update-membre/update-membre.component';
import { MembreDetailsComponent } from './membre/membre-details/membre-details.component';
import { AnimalsListComponent } from './animal/animals-list/animals-list.component';
import { CreateAnimalComponent } from './animal/create-animal/create-animal.component';
import { UpdateAnimalComponent } from './animal/update-animal/update-animal.component';
import { AnimalDetailsComponent } from './animal/animal-details/animal-details.component';
import { TasksListComponent } from './tasks/tasks-list/tasks-list.component';
import { CreateTaskComponent } from './tasks/create-task/create-task.component';
import { UpdateTaskComponent } from './tasks/update-task/update-task.component';
import { TaskDetailsComponent } from './tasks/task-details/task-details.component';


@NgModule({
  declarations: [
    AppComponent,
    MembresListComponent,
    CreateMembreComponent,
    UpdateMembreComponent,
    MembreDetailsComponent,
    AnimalsListComponent,
    CreateAnimalComponent,
    UpdateAnimalComponent,
    AnimalDetailsComponent,
    TasksListComponent,
    CreateTaskComponent,
    UpdateTaskComponent,
    TaskDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
