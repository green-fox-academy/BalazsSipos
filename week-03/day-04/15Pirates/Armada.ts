'use strict';

import { Ship } from './Ship';

class Armada {
  ships: Ship[] = [];

  fillAndInitializeArmada(): void {
    //create 4-8 ships
    let rand: number = Math.ceil(Math.random() * 5);
    let tempShip: Ship;
    for (let i: number = 1; i <= 3 + rand; i++) {
      tempShip = new Ship();
      tempShip.initializeForWar();
      this.ships.push(tempShip);
    }
  }

  war(otherArmada) {
    let currentShip: any = this.getTheFirstAliveShip();
    let otherCurrentShip: any = otherArmada.getTheFirstAliveShip();
    let battleWins: number = 0;
    let battleLosses: number = 0;

    while (currentShip && otherCurrentShip) {
      // if(currentPirate && otherCurrentPirate) { // of both are alive

      if (currentShip.battle(otherCurrentShip)) {
        battleWins++;
      } else {
        battleLosses++;
      }

      currentShip = this.getTheFirstAliveShip();
      otherCurrentShip = otherArmada.getTheFirstAliveShip();

    }

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