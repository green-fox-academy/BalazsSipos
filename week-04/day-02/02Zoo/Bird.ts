'use strict';

import { BreedWithEgg } from "./BreedWithEgg";
import { Flyable } from "../03Flyable/Flyable";

class Bird extends BreedWithEgg implements Flyable {
  takeoffLength: number = 10;
  land(): string {
    return `The ${this.color} colored, ${this.age} year old ${this.gender} ${this.name} has landed.`;
  };
  fly(): string {
    return `The ${this.color} colored, ${this.age} year old ${this.gender} ${this.name} is flying.`;
  };
  takeoff(): string {
    return `The ${this.color} colored, ${this.age} year old ${this.gender} ${this.name} has taken off. It needed ${this.takeoffLength} m to taken off.`;
  };
}

export { Bird };