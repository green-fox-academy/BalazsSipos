'use strict';

class DiceSet {
  dice: number[];
  readonly numOfDices: number = 6;

  roll(): number[] {
    this.dice = [];
    for (let i = 0; i < this.numOfDices; i++) {
      this.dice.push(Math.floor(Math.random() * 6 + 1));
    }
    return this.dice;
  }

  reroll(index?: number): void {
    if (index === undefined) {
      for (let i = 0; i < this.numOfDices; i++) {
        this.dice[i] = Math.floor(Math.random() * 6 + 1);
      }
    } else {
      this.dice[index] = Math.floor(Math.random() * 6 + 1);
    }
  }

  getCurrent(index?: number): number[] | number {
    if (index === undefined) {
      for (let i = 0; i < this.numOfDices; i++) {
        return this.dice;
      }
    } else {
      return this.dice[index];
    }
  }
}

// You have a `DiceSet` class which has a list for 6 dice
// You can roll all of them with roll()
// Check the current rolled numbers with getCurrent()
// You can reroll with reroll()
// Your task is to roll the dice until all of the dice are 6

class DiceManipulator {
  dS: DiceSet;
  counter: number = 0;

  constructor(dS: DiceSet) {
    this.dS = dS;
  }

  makeAllTo6(): void {
    let dS: DiceSet = this.dS;
    let counterOf6: number = 0; // to track, out of the 6 dices, how many are already 6
    // console.log(dS.dice.length);
    for (let i: number = 0; i < dS.dice.length; i++) {
      if (dS.dice[i] !== 6) { // if it is not 6, reroll that one
        dS.reroll(i);
        console.log(dS.getCurrent());
      } else {
        counterOf6++;
      }
    }
    this.counter++;
    if (this.counter < 50) { // just to avoid infinite loop
      if (counterOf6 < 6) {
        this.makeAllTo6();
      }
    }
  }
}

// Initialize a diceSet object
let diceSet = new DiceSet();
diceSet.roll();

// Initialize the dsManipulator object
let dSManipulator = new DiceManipulator(diceSet);

dSManipulator.makeAllTo6();