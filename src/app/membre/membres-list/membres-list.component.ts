import { Component, OnInit } from '@angular/core';
import { Membre } from 'src/app/models/membre';
import { MembreServiceService } from '../membre-service.service';

@Component({
  selector: 'app-membres-list',
  templateUrl: './membres-list.component.html',
  styleUrls: ['./membres-list.component.css']
})
export class MembresListComponent implements OnInit {

  membres!:Membre[];

  constructor(private membreService: MembreServiceService) { }

  ngOnInit(): void {
    this.getMembers();
  }

   getMembers(){
    this.membreService.getMembresList().subscribe(data => {
      this.membres = data;
    });
  }
}
