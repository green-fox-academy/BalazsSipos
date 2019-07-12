'use strict';

// We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).

function bunnies(num: number): number {
  if (num <= 1) {
    return 2;
  } else {
    if (num % 2 === 0) {
      return 3 + bunnies(num - 1);
    } else {
      return 2 + bunnies(num - 1);
    }
  }
}

console.log(bunnies(5));