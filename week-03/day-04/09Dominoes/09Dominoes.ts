'use strict';
declare var require: any
const util = require('util');

import { Domino } from "./domino";

/** You have the list of Dominoes */
/** Order them into one snake where the adjacent dominoes have the same numbers on their adjacent sides */
/** eg: [2, 4], [4, 3], [3, 5] ... */

function initializeDominoes(): Domino[] {
  let dominoes = [];
  dominoes.push(new Domino(2, 5));
  dominoes.push(new Domino(4, 6));
  dominoes.push(new Domino(1, 5));
  dominoes.push(new Domino(6, 7));
  dominoes.push(new Domino(2, 4));
  dominoes.push(new Domino(7, 1));
  return dominoes;
}

let dominoes = initializeDominoes();

class OrderDominoes {
  dominoes: Domino[];

  constructor(dominoes: Domino[]) {
    this.dominoes = dominoes;
  }

  print(): void {
    let dominoes = this.dominoes;
    dominoes.forEach(function (value) {
      console.log(value);
    });
  }

  // This is the main method, which build up a new array of Dominos in correct order
  order(): Domino[] {
    let originalDoms: Domino[] = this.dominoes; // the original unordered dominoes' array
    let resultDoms: Domino[] = []; // the new ordered dominos' array
    let lookupNumber: number; // this is the second number of the current domino, this should be searched in other dominoes
    let currentIndex: number = 0;
    let tempNumber: number;

    // Loop through the original Dominoes
    for (let i: number = 0; i < originalDoms.length; i++) {
      if (i !== 0) {

        // Check if the looked up number is the first element of the domino, otherwise they have to be changed
        if (originalDoms[currentIndex].values[0] !== lookupNumber) {
          tempNumber = originalDoms[currentIndex].values[0];
          originalDoms[currentIndex].values[0] = originalDoms[currentIndex].values[1];
          originalDoms[currentIndex].values[1] = tempNumber;
        }
      }

      // Push the current element to the result array's end
      resultDoms.push(originalDoms[currentIndex]);

      // Check the second number of the domino we are searching now in the other dominoes
      lookupNumber = originalDoms[currentIndex].values[1];

      // Remove the searched Domino from the original array, so in the next loop this domino will not be picked up again
      delete originalDoms[currentIndex];

      // Loop through the remaining array, and search for the number
      currentIndex = this.searchForNumberInDomino(originalDoms, lookupNumber);
      if (currentIndex === -1) {
        break;
      }
    }
    return resultDoms;
  }

  // Search inside the dominoes for a specifi number, and gives back the index of the Domino, if found, otherwise -1
  searchForNumberInDomino(originalDoms: Domino[], lookupNumber: number): number {
    for (let i: number = 0; i < originalDoms.length; i++) {
      if (originalDoms[i] && originalDoms[i].values.indexOf(lookupNumber) > -1) {
        return i;
      }
    }
    return -1;
  }
}

let od: OrderDominoes = new OrderDominoes(dominoes);
console.log(od.order());