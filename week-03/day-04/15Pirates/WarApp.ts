'use strict';
declare function require(path: string): any;
const util = require('util');

import { Armada } from './Armada';

class WarApp{
  armada: Armada;
  otherArmada: Armada;
  numberOfShips: number[]; // from till, [4, 8] means 4-8 ships for both armadas
  numberOfPirates: number[]; // from till, [4, 8] means 4-8 pirates for all ships

  constructor(shipNumber: number[] = [4,8], piratesNumber: number[] = [4,8]){
    this.armada= new Armada(shipNumber, piratesNumber);
    this.otherArmada= new Armada(shipNumber, piratesNumber);
    this.numberOfShips = shipNumber;
    this.numberOfPirates = piratesNumber;
  }
  
  initializeArmadasForWar(){
    this.armada.fillAndInitializeArmada();
    console.log(util.inspect(this.armada, {showHidden: false, depth: null}));
    // console.log(this.armada);
    this.otherArmada.fillAndInitializeArmada();
    // console.log(this.otherArmada);

  }

  calculateStatistics(armada: Armada){
    let piratesDied = 0;
    let piratesSleeping = 0;
    let piratesAlive = 0;
    armada.ships.forEach(element => {
      element.crew.forEach(element => {
        if(element.state === 'alive') {
          piratesAlive++;
        } else if(element.state === 'sleeping') {
          piratesSleeping++;
        } else if(element.state === 'died'){
          piratesDied++;
        }
      });
    });
    return {'alive': piratesAlive, 'sleeping': piratesSleeping, 'died': piratesDied};
  }
}

// Create an Armada
let war: WarApp = new WarApp([4,8], [4,8]);
war.initializeArmadasForWar();
let result: number[] = war.armada.war(war.otherArmada);
console.log(util.inspect(war.armada, {showHidden: false, depth: null}));
console.log(util.inspect(war.otherArmada, {showHidden: false, depth: null}));
console.log(result);
// collecting statistics
console.log(war.calculateStatistics(war.armada));
console.log(war.calculateStatistics(war.otherArmada));