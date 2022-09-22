import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MembresListComponent } from './membre/membres-list/membres-list.component';

const routes: Routes = [
  {path:'membres',component:MembresListComponent},
  {path: '', redirectTo: 'membres', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
