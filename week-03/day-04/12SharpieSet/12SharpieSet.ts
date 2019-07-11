'use strct';

import { Sharpie } from '../../day-03/04Sharpie/04Sharpie';

// Reuse your Sharpie class
// Create SharpieSet class
// it contains a list of Sharpie
// countUsable() -> sharpie is usable if it has ink in it
// removeTrash() -> removes all unusable sharpies


class SharpieSet {
  sharpies: Sharpie[] = [];

  addSharpie(adds: Sharpie) {
    this.sharpies.push(adds);
  }

  // COunt the sharpies with non-zero ink amount
  countUsable(): number {
    let counter: number = 0;
    for (let i: number = 0; i < this.sharpies.length; i++) {
      if (this.sharpies[i].inkAmount > 0) {
        counter++;
      }
    }
    return counter;
  }

  // Remove the sharpies with zero ink amount
  removeTrash() {
    for (let i: number = 0; i < this.sharpies.length; i++) {
      if (this.sharpies[i].inkAmount === 0) {
        this.sharpies.splice(i, 1);
      }
    }
  }
}

// Instantiates 3 Sharpie objects
let sharpie1: Sharpie = new Sharpie('green', 30, 80);
let sharpie2: Sharpie = new Sharpie('yellow', 20, 10);
let sharpie3: Sharpie = new Sharpie('green', 20);

// Instantiates a SharpieSet object
let sS: SharpieSet = new SharpieSet();

// Test the methods
console.log('------------------------------------');
console.log(sS);

sS.addSharpie(sharpie1);
sS.addSharpie(sharpie2);
sS.addSharpie(sharpie3);
console.log(sS);

console.log(sS.countUsable());

sS.sharpies[0].use(80);
sS.sharpies[2].use(100);
console.log(sS);
console.log(sS.countUsable());
console.log(sS);

sS.removeTrash();
console.log(sS);