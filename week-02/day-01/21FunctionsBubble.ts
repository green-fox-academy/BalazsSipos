'use strict';

//  Create a function that takes a list of numbers as parameter
//  Returns a list where the elements are sorted in ascending numerical order
//  Make a second boolean parameter, if it's `true` sort that list descending

function bubble(inputNumbers: number[]): number[] {
  return inputNumbers.sort((n1, n2) => n1 - n2);
}

function advancedBubble(inputNumbers: number[], desc: boolean): number[] {
  if (desc) {
    return inputNumbers.sort((n1, n2) => n2 - n1);
  } else {
    return inputNumbers.sort((n1, n2) => n1 - n2);
  }
}
//  Example:
console.log(bubble([34, 12, 24, 9, 5]));
//  should print [5, 9, 12, 24, 34]
console.log(advancedBubble([34, 12, 24, 9, 5], true));
//  should print [34, 24, 12, 9, 5]