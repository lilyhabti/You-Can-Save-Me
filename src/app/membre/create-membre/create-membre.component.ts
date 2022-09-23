import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Membre } from 'src/app/models/membre';
import { MembreServiceService } from '../membre-service.service';

@Component({
  selector: 'app-create-membre',
  templateUrl: './create-membre.component.html',
  styleUrls: ['./create-membre.component.css']
})
export class CreateMembreComponent implements OnInit {

  membre:Membre=new Membre();

  constructor(private membreService : MembreServiceService,private router:Router) { }

  ngOnInit(): void {
  }

  saveMembre(){
    this.membreService.createMembre(this.membre).subscribe( data =>{
      console.log(data);
      this.goToMembresList();
    },
    error => console.log(error));
  }

  goToMembresList(){
    this.router.navigate(['/membres']);
  }
  
  onSubmit(){
    console.log(this.membre);
    this.saveMembre();
  }

}
