'use strict';

// Create a Station and a Car classes
// Station
// gasAmount
// refill(car) -> decreases the gasAmount by the capacity of the car and increases the cars gasAmount
// Car
// gasAmount
// capacity
// create constructor for Car where:
// initialize gasAmount -> 0
// initialize capacity -> 100

class Station {
  gasAmount: number = 1000;

  refill(car: Car): void {
    this.gasAmount -= (car.capacity - car.gasAmount);
    car.gasAmount = car.capacity;
  }

}

class Car {
  gasAmount: number;
  capacity: number;

  constructor(gas: number = 0, cap: number = 100) {
    this.gasAmount = gas;
    this.capacity = cap;
  }
}

let station: Station = new Station();
console.log(station);

let car1: Car = new Car(10);
let car2: Car = new Car();
let car3: Car = new Car(0, 80);

//-------------------------------------------
// Check functions
console.log(car1);
console.log(car2);
console.log(car3);

station.refill(car1);
console.log(station);
console.log(car1);

station.refill(car2);
console.log(station);
console.log(car2);

station.refill(car3);
console.log(station);
console.log(car3);
