import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Animal } from 'src/app/models/animal';
import { AnimalService } from '../animal.service';

@Component({
  selector: 'app-animal-details',
  templateUrl: './animal-details.component.html',
  styleUrls: ['./animal-details.component.css']
})
export class AnimalDetailsComponent implements OnInit {

  id_animal!:number;
  animal!:Animal;

  constructor(private animalService : AnimalService,private route : ActivatedRoute) { }

  ngOnInit(): void {
    this.id_animal = this.route.snapshot.params['id_animal'];

    this.animal = new Animal();
    this.animalService.getAnimalById(this.id_animal).subscribe( data => {
      this.animal = data;
    });
  }

}
