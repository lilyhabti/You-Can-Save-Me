import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Animal } from 'src/app/models/animal';
import { AnimalService } from '../animal.service';

@Component({
  selector: 'app-animals-list',
  templateUrl: './animals-list.component.html',
  styleUrls: ['./animals-list.component.css']
})
export class AnimalsListComponent implements OnInit {

  animals!:Animal[];

  constructor(private animalService : AnimalService,private router : Router) { }

  ngOnInit(): void {
    this.getAnimals();
  }

  private getAnimals(){
    this.animalService.getAnimalsList().subscribe(data => {
      this.animals = data;
    });
  }
  updateAnimal(id_animal: number){
    this.router.navigate(['update-animal', id_animal]);
  }
  deleteAnimal(id_animal: number){
    this.animalService.deleteAnimal(id_animal).subscribe( data => {
      console.log(data);
      this.getAnimals();
    })
  }
  animalDetails(id_animal: number){
    this.router.navigate(['animal-details', id_animal]);
  }
}
