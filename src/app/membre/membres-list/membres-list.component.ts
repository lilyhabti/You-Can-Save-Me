import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Membre } from 'src/app/models/membre';
import { MembreServiceService } from '../membre-service.service';

@Component({
  selector: 'app-membres-list',
  templateUrl: './membres-list.component.html',
  styleUrls: ['./membres-list.component.css']
})
export class MembresListComponent implements OnInit {

  membres!:Membre[];

  constructor(private membreService: MembreServiceService,private router:Router) { }

  ngOnInit(): void {
    this.getMembers();
  }

   getMembers(){
    this.membreService.getMembresList().subscribe(data => {
      this.membres = data;
    });
  }
  updateMembre(id_user: number){
    this.router.navigate(['update-membre', id_user]);
  }

  deleteMember(id_user: number){
    this.membreService.deleteMember(id_user).subscribe( data => {
      console.log(data);
      this.getMembers();
    })
  }

  memberDetails(id_user:number){
    this.router.navigate(['membre-details', id_user]);
  }
}
