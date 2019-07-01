'use strict';

// -  Create a string variable named `typo` and assign the value `Chinchill` to it
let type: string = 'Chinchill';
// -  Write a function called `appendAFunc` that gets a string as an input,
//    appends an 'a' character to its end and returns with a string
function appendAFunc(input: string): string {
  return input + 'a';
}
// -  Print the result of `appendAFunc(typo)`
console.log(appendAFunc(type));