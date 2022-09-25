import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Animal } from 'src/app/models/animal';
import { AnimalService } from '../animal.service';

@Component({
  selector: 'app-create-animal',
  templateUrl: './create-animal.component.html',
  styleUrls: ['./create-animal.component.css']
})
export class CreateAnimalComponent implements OnInit {

  animal:Animal=new Animal();

  constructor(private animalService : AnimalService,private router:Router) { }

  ngOnInit(): void {
  }

  saveAnimal(){
    this.animalService.createAnimal(this.animal).subscribe( data =>{
      console.log(data);
      this.goToAnimalList();
    },
    error => console.log(error));
  }

  goToAnimalList(){
    this.router.navigate(['/animals']);
  }
  
  onSubmit(){
    console.log(this.animal);
    this.saveAnimal();
  }

}
