'use strict';

import { Ship } from './Ship';

class Armada {
  ships: Ship[] = [];
  numberOfShips: number[]; // from till, [4, 8] means 4-8 ships for both armadas
  numberOfPirates: number[]; // from till, [4, 8] means 4-8 pirates for all ships

  constructor(shipNumber: number[], piratesNumber: number[]) {
    this.numberOfShips = shipNumber;
    this.numberOfPirates = piratesNumber;
  }

  fillAndInitializeArmada(): void {
    //create 4-8 ships
    let rand: number = Math.ceil(Math.random() * (this.numberOfShips[1]-this.numberOfShips[0]+1));
    // let rand: number = 0;
    let tempShip: Ship;
    for (let i: number = 1; i <= this.numberOfShips[0]-1 + rand; i++) {
      tempShip = new Ship(this.numberOfPirates);
      tempShip.initializeForWar();
      this.ships.push(tempShip);
    }
  }

  war(otherArmada): number[] {
    let currentShip: any = this.getTheFirstAliveShip();
    let otherCurrentShip: any = otherArmada.getTheFirstAliveShip();
    let battleWins: number = 0;
    let battleLosses: number = 0;
    let lastWinner: number = -1;

    while (currentShip && otherCurrentShip) {
      // if(currentPirate && otherCurrentPirate) { // of both are alive

      if (currentShip.battle(otherCurrentShip)) {
        battleWins++;
        lastWinner = 0;
      } else {
        battleLosses++;
        lastWinner = 1;
      }

      currentShip = this.getTheFirstAliveShip();
      otherCurrentShip = otherArmada.getTheFirstAliveShip();

    }
    return [battleWins, battleLosses, lastWinner];

  }

  private getTheFirstAliveShip(): any {
    for (let i: number = 0; i < this.ships.length; i++) {
      if (this.ships[i].state === 'alive') {
        return this.ships[i];
      }
    }
    return false;
  }

}

export { Armada };