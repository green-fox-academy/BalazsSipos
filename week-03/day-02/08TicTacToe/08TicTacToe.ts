'use strict';

// Write a function that takes a filename as a parameter
// The file contains an ended Tic-Tac-Toe match
// We have provided you some example files (draw.txt, win-x.txt, win-o.txt)
// Return "X", "O" or "Draw" based on the input file

declare function require(path: string): any
const fs = require('fs');


function ticTacResult(fileName: string) {
  let fileContent: string = '';
  try {
    fileContent = fs.readFileSync(fileName, 'utf-8');
  } catch (e) {
    return e.message;
  }
  let contentArray: string[] = [];
  let contentMulti: string[][] = [];
  contentArray = fileContent.split('\n');

  // Create a 2 dimensional array
  contentArray.forEach(function (value: string, index: number) {
    contentMulti[index] = value.split('');
  });

  for (let index: number = 0; index < contentMulti.length; index++) {
    // Check vertical
    if (contentMulti[0][index] === contentMulti[1][index] && contentMulti[1][index] === contentMulti[2][index]) {
      return contentMulti[0][index];
    }

    // Check horizontal
    if (contentMulti[index][0] === contentMulti[index][1] && contentMulti[index][1] === contentMulti[index][2]) {
      return contentMulti[index][0];
    }

  }
  // Check diagonal
  if ((contentMulti[0][0] === contentMulti[1][1] && contentMulti[1][1] === contentMulti[2][2]) || (contentMulti[0][2] === contentMulti[1][1] && contentMulti[1][1] === contentMulti[2][0])) {
    return contentMulti[1][1];
  }
  return 'draw';
}

console.log(ticTacResult('win-o.txt'))
// Should print "O"

console.log(ticTacResult('win-x.txt'))
// Should print "X"

console.log(ticTacResult('draw.txt'))
// Should print "Draw"