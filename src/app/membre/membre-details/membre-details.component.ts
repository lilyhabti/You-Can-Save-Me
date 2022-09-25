import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Membre } from 'src/app/models/membre';
import { MembreServiceService } from '../membre-service.service';

@Component({
  selector: 'app-membre-details',
  templateUrl: './membre-details.component.html',
  styleUrls: ['./membre-details.component.css']
})
export class MembreDetailsComponent implements OnInit {

  id_user!:number;
  member!:Membre;

  constructor(private membreService : MembreServiceService,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.id_user = this.route.snapshot.params['id_user'];

    this.member = new Membre();
    this.membreService.getMembreById(this.id_user).subscribe( data => {
      this.member = data;
    });
  }

}
