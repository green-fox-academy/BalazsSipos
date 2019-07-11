'use strict';

// Reuse your Animal class
// Create a Farm class
// it has list of Animals
// it has slots which defines the number of free places for animals
// breed() -> creates a new animal if there's place for it
// slaughter() -> removes the least hungry animal

import { Animal } from '../../day-03/03Animal/03Animal';

class Farm {
  animals: Animal[] = [];
  numberOfPlaces: number = 10;

  addAnimal(adds: Animal) {
    this.animals.push(adds);
  }

  // If there is free space in the farm, it adds a new Animal with random hunger and thirst values
  breed() {
    let numberOfAnimals: number = this.animals.length;
    if (numberOfAnimals < this.numberOfPlaces) {
      this.animals.push(new Animal(Math.ceil(Math.random() * 50), Math.ceil(Math.random() * 50)));
    }
  }

  // If there at least one animal in the farm, it will remove least hungry animal (lowest hunger value)
  slaughter() {
    let min: number[] = [-1, 51]; // stores the minimum hunger value ([index, value])
    if (this.animals.length >= 1) {
      for (let i: number = 0; i < this.animals.length; i++) {
        if (this.animals[i].hunger < min[1]) {
          min[0] = i;
          min[1] = this.animals[i].hunger;
        }
      }
    }
    this.animals.splice(min[0], 1);
  }
}

let farm: Farm = new Farm();

// Test the methods
console.log(farm);

farm.breed();
farm.breed();
farm.breed();
farm.breed();
farm.breed();
farm.breed();
farm.breed();
farm.breed();
farm.breed();
farm.breed();
farm.breed(); // this will not be executed, if farm size is 10

console.log(farm);
farm.slaughter();
console.log(farm);

farm.breed();
farm.breed(); // this will not be executed, if farm size is 10
console.log(farm);