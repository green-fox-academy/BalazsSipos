'use strict';

// Write a function that finds the largest element of an array using recursion.

function maximum(arr: number[]) {
  if (arr.length <= 1) {
    return arr[0];
  } else {
    if (arr[0] > arr[1]) {
      arr.splice(1, 1);
      return maximum(arr);
    } else {
      arr.splice(0, 1);
      return maximum(arr);
    }
  }
}

console.log(maximum([1, 2, 3, 4, 212, 23, 1, 4]));