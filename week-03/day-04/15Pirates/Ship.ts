'use strict';

import { Pirate } from './Pirate';

class Ship {
  crew: Pirate[] = [];
  captain: Pirate;

  fillShip(): void {
    // Create 4-8 pirates + 1 captain
    let rand: number = Math.ceil(Math.random() * 5);
    for (let i: number = 1; i <= 3 + rand; i++) {
      this.crew.push(new Pirate());
    }
    this.captain = new Pirate();
  }

  initializeForWar(): void {
    this.fillShip();
    console.log(this);
    this.shipDrinkSomeRum(2);
  }

  battle(otherShip: Ship): boolean {
    const ownPoints: number = this.getNumberOfAlivePirates() - this.captain.rumNumber;
    const otherPoints: number = otherShip.getNumberOfAlivePirates() - otherShip.captain.rumNumber;

    if (ownPoints > otherPoints) {
      this.shipDrinkSomeRum(2);
      otherShip
    }
  }

  getNumberOfAlivePirates() {
    let numberOfAlive: number = 0;
    this.crew.forEach(element => {
      if (element.state === 'alive') {
        numberOfAlive++;
      }
    });
    return numberOfAlive;
  }

  shipDrinkSomeRum(max: number) {
    for (let i: number = 1; i < this.crew.length; i++) {
      this.crew[i].drinkSomeRum(max);
      this.crew[i].howsItGoingMate();
    }
    this.captain.drinkSomeRum(2);
  }

  killSomePirates() {
    let numberOfAlivePirates: number = this.getNumberOfAlivePirates();
    let randomNumberOfDeath: number = Math.ceil(Math.random() * numberOfAlivePirates / 2);
    let deathCounter: number = 0;
    for (let i: number = 0; i < this.crew.length; i++) {
      if (deathCounter < randomNumberOfDeath) {
        if (this.crew[i].state !== 'died') {
          this.crew[i].state === 'died';
          deathCounter++;
        }
      } else {
        break;
      }
    }
  }
}

export { Ship };
// Create a ship
let ship1: Ship = new Ship();
console.log(ship1);
ship1.initializeForWar();
console.log(ship1);