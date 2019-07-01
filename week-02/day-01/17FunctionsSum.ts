'use strict';
let sumOfTillNumber = 10;

// Write a function called `sum` that returns the sum of numbers from zero to the given parameter
function sum(inputNumber: number):  Number {
  let sumOf: number = 0;
  for(let i:number = 0;i<=inputNumber;i++) {
    sumOf += i;
  }
  return sumOf;
}

console.log(sum(sumOfTillNumber));