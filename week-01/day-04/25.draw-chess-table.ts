'use strict';

// Create a program that draws a chess table like this
//
// % % % %
//  % % % %
// % % % %
//  % % % %
// % % % %
//  % % % %
// % % % %
//  % % % %
for (let i: number = 1; i <= 8; i++) {
  let collector: string = '';
  for (let j: number = 1; j <= 8; j++) {
    if ((0 == i % 2 && 0 == j % 2) || (0 != i % 2 && 0 != j % 2)) {
      collector += '%';
    } else {
      collector += ' ';
    }
  }
  console.log(collector);
}