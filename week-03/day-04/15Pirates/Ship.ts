'use strict';

import { Pirate } from './Pirate';

class Ship {
  crew: Pirate[] = [];
  captain: Pirate;
  state: string = 'alive';

  private fillShip(): void {
    // Create 4-8 pirates + 1 captain
    let rand: number = Math.ceil(Math.random() * 5);
    for (let i: number = 1; i <= 3 + rand; i++) {
      this.crew.push(new Pirate());
    }
    this.captain = new Pirate();
  }

  initializeForWar(): void {
    this.fillShip();
    // console.log(this);
    this.shipDrinkSomeRum(2);
  }

  battle(otherShip: Ship): boolean {
    let currentPirate: any = this.getTheFirstAlivePirate();
    let otherCurrentPirate: any = otherShip.getTheFirstAlivePirate();


    while (currentPirate && otherCurrentPirate) {
      // if(currentPirate && otherCurrentPirate) { // of both are alive

      currentPirate.brawl(otherCurrentPirate);
      console.log(this);
      console.log(otherShip);

      currentPirate = this.getTheFirstAlivePirate();
      otherCurrentPirate = otherShip.getTheFirstAlivePirate();

    }

    return this.handleBattleResult(otherShip);
  }

  private getNumberOfNotDeadPirates(): number {
    let numberOfAlive: number = 0;
    this.crew.forEach(element => {
      if (element.state !== 'died') {
        numberOfAlive++;
      }
    });
    return numberOfAlive;
  }

  private shipDrinkSomeRum(max: number): void {
    for (let i: number = 1; i < this.crew.length; i++) {
      this.crew[i].drinkSomeRum(max);
      this.crew[i].howsItGoingMate();
    }
    this.captain.drinkSomeRum(2);
  }

  private killSomePirates(): void {
    let getNumberOfNotDeadPirates: number = this.getNumberOfNotDeadPirates();
    console.log(getNumberOfNotDeadPirates);
    let randomNumberOfDeath: number = Math.ceil(Math.random() * getNumberOfNotDeadPirates / 2);
    console.log(randomNumberOfDeath);
    let deathCounter: number = 0;
    console.log(this.crew.length);
    for (let i: number = 0; i < this.crew.length; i++) {

      if (deathCounter < randomNumberOfDeath) {
        if (this.crew[i].state !== 'died') {
          console.log(this.crew[i].state);

          this.crew[i].state = 'died';
          deathCounter++;
        }
      } else {
        break;
      }
    }
  }

  private getTheFirstAlivePirate(): any {
    for (let i: number = 0; i < this.crew.length; i++) {
      if (this.crew[i].state === 'alive') {
        return this.crew[i];
      }
    }
    return false;
  }

  
  private handleBattleResult(otherShip: Ship): boolean {
    const ownPoints: number = this.currentPointsCalculator();
    const otherPoints: number = otherShip.currentPointsCalculator();
    
    console.log(ownPoints);
    console.log(otherPoints);
    
    if (ownPoints > otherPoints) {
      this.shipDrinkSomeRum(2);
      otherShip.killSomePirates();
      otherShip.state = 'died';
      console.log(this);
      console.log(otherShip);
      return true;
    } else {
      this.killSomePirates();
      otherShip.shipDrinkSomeRum(2);
      console.log(this);
      console.log(otherShip);
      return false;
    }
  }
  
  private currentPointsCalculator(): number {
    return this.getNumberOfNotDeadPirates() - this.captain.rumNumber;
  }
}

export { Ship };