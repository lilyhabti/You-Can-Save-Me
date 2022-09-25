import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Animal } from 'src/app/models/animal';
import { AnimalService } from '../animal.service';

@Component({
  selector: 'app-update-animal',
  templateUrl: './update-animal.component.html',
  styleUrls: ['./update-animal.component.css']
})
export class UpdateAnimalComponent implements OnInit {

  id_animal!:number;
  animal:Animal=new Animal();
  constructor(private animalService:AnimalService,private router:Router,private route : ActivatedRoute) { }

  ngOnInit(): void {
    this.id_animal = this.route.snapshot.params['id_animal'];

    this.animalService.getAnimalById(this.id_animal).subscribe(data => {
      this.animal = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.animalService.updateEmployee(this.id_animal,this.animal).subscribe( data =>{
      this.goToAnimalsList();
    }
    , error => console.log(error));
  }

  goToAnimalsList(){
    this.router.navigate(['/animals']);
  }
}
