'use strict';

import { Flower } from './Flower';
import { Tree } from './Tree';

class Garden {
  plants: Tree[] | Flower[] = [];

  addPlants(plant: Flower | Tree) {
    this.plants.push(plant);
  }

  // Check each plant, if needs watering
  analyseGarden(): void {
    this.plants.forEach(element => {
      element.isNeedsWatering();
      let type: string = '';

      // Check the type of element (Flower or Tree)
      if (element instanceof Flower) {
        type = 'Flower';
      } else if (element instanceof Tree) {
        type = 'Tree';
      }

      if (element.needsWater) {
        console.log(`The ${element.color} ${type} needs water`);
      } else {
        console.log(`The ${element.color} ${type} does NOT need water`);
      }
    });
  }

  // Waters the thirsty plants equally
  waterGarden(waterQuantity: number): void {
    const thirstyPlants = this.countThirstyPlants();
    this.plants.forEach(element => {
      if (element.needsWater) {
        element.watering(waterQuantity / thirstyPlants);
      }
    });
  }

  countThirstyPlants(): number {
    let counter: number = 0;
    this.plants.forEach(element => {
      if (element.needsWater) {
        counter++;
      }
    });
    return counter;
  }
}

export { Garden };