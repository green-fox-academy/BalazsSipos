'use strict';

// Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power, so powerN(3, 2) is 9 (3 squared).

function powerN(base: number, power: number): number {
  if (base >= 1 && power >= 1) {
    if (power <= 1) {
      return base;
    } else {
      return base * powerN(base, power - 1);
    }
  }
}

console.log(powerN(2, 3));