'use strict';

// Given a non-negative integer n, return the sum of its digits recursively (without loops).

function sumOfDigits(num: number) {
  if (num / 10 <= 1) {
    return num;
  } else {
    return (num % 10) + sumOfDigits((num - (num % 10)) / 10);
  }
}

console.log(sumOfDigits(3263));