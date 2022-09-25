import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Membre } from 'src/app/models/membre';
import { MembreServiceService } from '../membre-service.service';

@Component({
  selector: 'app-update-membre',
  templateUrl: './update-membre.component.html',
  styleUrls: ['./update-membre.component.css']
})
export class UpdateMembreComponent implements OnInit {

  id_user!:number;
  membre:Membre=new Membre();

  constructor(private membreService : MembreServiceService,private route : ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.id_user = this.route.snapshot.params['id_user'];

    this.membreService.getMembreById(this.id_user).subscribe(data => {
      this.membre = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.membreService.updateMember(this.id_user,this.membre).subscribe( data =>{
      this.goToMembresList();
    }
    , error => console.log(error));
  }

  goToMembresList(){
    this.router.navigate(['/membres']);
  }
}
