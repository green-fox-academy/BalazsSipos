'use strict';

import { Vehicle } from "./Vehicle";
import { Flyable } from "./Flyable";

class Helicopter extends Vehicle implements Flyable {
  takeoffLength: number;
  numberOfPropellers: number;

  constructor(color: string, age: number, takeoffLength: number, propellers: number) {
    super(color, age);
    this.type = 'Helicopter';
    this.takeoffLength = takeoffLength;
    this.numberOfPropellers = propellers;
  }

  land(): string {
    this.hasEngineStarted = false;

    return `The ${this.color} colored, ${this.age} year old ${this.type} has landed.`;
  }

  fly(): string {
    return `The ${this.color} colored, ${this.age} year old ${this.type} is flying.`;
  }

  takeoff(): string {
    this.startEngine();

    return `The ${this.color} colored, ${this.age} year old ${this.type} has taken off.`;
  }
}

export { Helicopter };