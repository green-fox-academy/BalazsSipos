'use strict';

// DESCRIPTION FROM THE REPO
//What the hell is Josephus Problem?
// Flavius Josephus was a famous historian of the first century. During the Jewish-Roman war, he was among a band of 41 Jewish rebels trapped in a cave by the Romans. Preferring suicide to capture, the rebels decided to kill themselves. Using a method to form a circle and in clockwise direction everybody kills the person on his left side until everyone dies. But Josephus, wanted none of this suicide nonsense and therefore quickly calculated where he should stand in the circle so that he will be the last one (he knew who is the first one). So basically Josephus Problem is when you have a circle of n people standing and you want to cross out every second person step-by-step until only one remains. for more detail check Josephus Problem on Wikipedia]

// Write a function to solve Josephus Problem. The program should ask for a number, this number represents how many people are in the "game". The return value should be the number of the "winning" seat.


// OWN COMMENTS
// function survivor(numberOfPeople: number) {
//   for (let i: number = 0; i < numberOfPeople; i++) {
//     let array = new Array(numberOfPeople);
//     console.log(array);
//     if (array[i]) {
//       console.log(i + ' Not empty');
//     } else {
//       console.log(i + ' Empty');
//       if (i !== numberOfPeople - 1) {

//       }
//     }
//   }
// }

// Set the number of people
let numberOfPeople = 41;

let survivorCalculator = {
  peopleNumber: 0, // Number of people in the "game"
  killer: true, // Shows whether it is a killer or a killed loop
  counter: 0, // Number of "empty" loops, used as a flag to break out of the loops, when we have the winner
  killedArray: [], // an array of people to track, who has already been killed, e.g. ['x','x', empty, 'x', empty];
  loopCounter: 0, // a dummy loop counter to give a maximum number to avoid infinite loop
  lastKilled: -1, // it tracks the people killed last (at the end it holds the winner)

  forLoop: function (starterNumber: number) {
    let peopleNumberA = this.peopleNumber;
    let killedA: string[] = this.killedArray;
    let isKiller = this.killer;

    for (let i: number = starterNumber; i < peopleNumberA; i++) {
      if (!killedA[i]) { // we only need to bother, if the element is empty
        if (isKiller) { // we have the current round's killer
          this.killer = false;
        } else { // we have the current round's killed person
          this.killedArray[i] = 'x';
          this.killer = true;
          this.counter = 0; // set back the flag to 0
          this.lastKilled = i;
        }
        if (i === peopleNumberA - 1) { // if it is the last element of array, we need to start again
          this.loopCounter++;
          if (this.loopCounter > 300) {
            break;
          }
          if (this.counter === 1) { // we already have a full cycle without killing, so break out
            break;
          } else {
            this.counter = 1;
          }
          this.forLoop(0);
        } else {
          this.loopCounter++;
          if (this.loopCounter > 300) {
            break;
          }
          this.forLoop(i + 1);
        }
      }
      if (i === peopleNumberA - 1) { // if it is the last element of array, we need to start again
        this.loopCounter++;
        if (this.loopCounter > 300) {
          break;
        }
        if (this.counter === 1) { // we already have a full cycle without killing, so break out
          break;
        } else {
          this.counter = 1;
        }
        this.forLoop(0);
      }
    }
  }
}

// Initialize
survivorCalculator.killedArray = new Array(numberOfPeople);
survivorCalculator.peopleNumber = numberOfPeople;

survivorCalculator.forLoop(0);
console.log(survivorCalculator);

console.log('SURVIVOR IS: ' + (survivorCalculator.lastKilled + 1));