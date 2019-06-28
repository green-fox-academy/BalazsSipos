'use strict';

let lineCount: number = 12;
let width: number = lineCount * 2 - 1;

// Write a program that draws a
// pyramid like this:
//
//    *
//   ***
//  *****
// *******
//
// The pyramid should have as many lines as lineCount is
for (let i: number = 1; i <= lineCount; i++) {
  let collector: string = '';
  for (let j: number = 1; j <= width; j++) {
    if (j <= lineCount - i || j > width - (lineCount - i)) {
      collector += ' ';
    } else {
      collector += '*';
    }
    //console.log(j);
  }
  console.log(collector);
}