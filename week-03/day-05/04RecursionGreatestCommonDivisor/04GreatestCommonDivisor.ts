'use strict';

// Find the greatest common divisor of two numbers using recursion.
function greatestCommonDivisor(num1: number, num2: number): number {
  if (num1 >= 1 && num2 >= 1) {
    if (num1 == num2) {
      return num1;
    } else if (num1 > num2) {
      if (num1 % num2 === 0) {
        return num2;
      } else {
        return greatestCommonDivisor(num1 - num2, num2);
      }
    } else if (num1 < num2) {
      if (num2 % num1 === 0) {
        return num1;
      } else {
        return greatestCommonDivisor(num2 - num1, num1);
      }
    }
  }
}

// Test cases
console.log(greatestCommonDivisor(16, 6)); // should be 2
console.log(greatestCommonDivisor(15, 6)); // should be 3
console.log(greatestCommonDivisor(24, 42)); // should be 6
console.log(greatestCommonDivisor(12, 6)); // should be 6
console.log(greatestCommonDivisor(16, 13)); // should be 1
console.log(greatestCommonDivisor(13, 13)); // should be 13
console.log(greatestCommonDivisor(13, 1)); // should be 1