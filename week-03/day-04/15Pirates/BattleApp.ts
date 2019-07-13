'use strict';

import { Ship } from './Ship';

class BattleApp{
  ship: Ship;
  otherShip: Ship;

  constructor(){
    this.ship= new Ship();
    this.otherShip= new Ship();
  }
  
  initializeShipsForBattle(){
    this.ship.initializeForWar();
    console.log(this.ship);
    this.otherShip.initializeForWar();
    console.log(this.otherShip);

  }
}

// Create a ship
let battle: BattleApp = new BattleApp();
battle.initializeShipsForWar();
battle.ship.battle(battle.otherShip);
// console.log(ship1);
// ship1.initializeForWar();
// console.log(ship1);