'use strict';

// We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).

function bunnies(num: number): number {
  if (num <= 1) {
    return 2;
  } else {
    return 2 + bunnies(num - 1);
  }
}

console.log(bunnies(5));