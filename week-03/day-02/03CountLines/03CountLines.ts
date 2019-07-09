'use strict';

// Write a function that takes a filename as string,
// then returns the number of lines the file contains.
// It should return zero if it can't open the file, and
// should not raise any error.
declare function require(path: string): any
const fs = require('fs');

function fileContentCounter(fileName: string): number {
  let lineCounter: number;
  try {
    let fileContent: string = fs.readFileSync('my-file.txt', 'utf-8');
    return fileContent.toString().split('\n').length;
  } catch (e) {
    return 0;
  }
}

console.log(fileContentCounter('my-file.txt'));