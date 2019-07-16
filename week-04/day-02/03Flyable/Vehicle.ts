'use strict';

abstract class Vehicle {
  type: string;
  color: string;
  age: number;
  hasEngineStarted: boolean = false;

  constructor(color: string, age: number = 0) {
    this.color = color;
    this.age = age;
  }

  startEngine(): void {
    this.hasEngineStarted = true
  }
}

export { Vehicle };