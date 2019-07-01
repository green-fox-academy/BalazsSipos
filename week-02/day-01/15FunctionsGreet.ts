'use strict';

// -  Create variable named `nameToGreet` and assign the value `Green Fox` to it
let nameToGreet: string = 'Green Fox';
// -  Create a function called `greet` that greets it's input parameter
function greet(input: string): string {
  return `Greetings, dear ${input}!`;
}
//     -  Greeting is printing e.g. `Greetings, dear Green Fox`
// -  Greet `nameToGreet`
console.log(greet(nameToGreet));