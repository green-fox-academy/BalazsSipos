'use strict';

// -  Create a variable named `ai` with the following content: `[3, 4, 5, 6, 7]`
let ai: number[] = [3, 4, 5, 6, 7];
let sum: number = 0;
// -  Log the sum of the elements in `ai` to the console
ai.forEach(function(value){
  sum += value;
});

console.log(sum);