'use strict';

// Write a program that prints the numbers from 1 to 100.
// But for multiples of three print “Fizz” instead of the number
// and for the multiples of five print “Buzz”.
// For numbers which are multiples of both three and five print “FizzBuzz”.
for (let i: number = 1; i <= 100; i++) {

  if (0 == i % 3 && 0 == i % 5) {
    console.log("FizzBuzz");
  } else if (0 == i % 3 && 0 != i % 5) {
    console.log("Fizz");
  } else if (0 != i % 3 && 0 == i % 5) {
    console.log("Buzz");
  } else {
    console.log(i);
  }
}