'use strict';

// Write a function that copies the contents of a file into another
// It should take the filenames as parameters
// It should return a boolean that shows if the copy was successful

declare function require(path: string): any
const fs = require('fs');

function copyContent(fileRead: string, fileWrite: string): boolean {
  try {
    let fileContent: string = fs.readFileSync(fileRead, 'utf-8');
    fs.writeFileSync(fileWrite, fileContent);
    return true;
  } catch (e) {
    console.log(e.message);
    return false;
  }
}

console.log(copyContent('my-file.txt', 'my-file-copy.txt'));