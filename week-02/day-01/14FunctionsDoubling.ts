'use strict';

// -  Create a variable named `baseNum` and assign the value `123` to it
let baseNum: number = 123;
// -  Create a function called `doubling` that doubles it's input parameter and returns with an integer
function doubling(inputNumber: number): number {
  return inputNumber * 2;
}
// -  Log the result of `doubling(baseNum)` to the console
console.log(doubling(baseNum));