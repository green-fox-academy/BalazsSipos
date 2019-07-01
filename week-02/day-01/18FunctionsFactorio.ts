'use strict';

let NumbersToMultiply = 5;

// -  Create a function called `factorio`
//    that returns it's input's factorial
function factorio(inputNumber: number): number {
  let Factor: number = 1;
  for (let i: number = 1; i <= inputNumber; i++) {
    Factor *= i;
  }
  return Factor;
}

console.log(factorio(NumbersToMultiply));