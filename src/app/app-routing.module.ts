import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateMembreComponent } from './membre/create-membre/create-membre.component';
import { MembresListComponent } from './membre/membres-list/membres-list.component';

const routes: Routes = [
  {path:'membres',component:MembresListComponent},
  {path:'create-membre',component:CreateMembreComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
