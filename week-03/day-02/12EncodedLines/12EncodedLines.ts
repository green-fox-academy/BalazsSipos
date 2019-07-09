'use strict';

// Create a method that decrypts encoded-lines.txt
declare function require(path: string): any
const fs = require('fs');

let fileContent: string = fs.readFileSync('encoded-lines.txt', 'utf-8');
let abc: string = ' abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ[-./!"';

function decrypt(content: string): string {
  let decryptedString: string = '';
  let contentArray: string[] = content.split('\n');
  let tempString: string = '';
  let charindex: number = 0;

  for (let i: number = 0; i < contentArray.length; i++) { // goes through the lines
    tempString = '';
    for (let j: number = 0; j < contentArray[i].length; j++) { // go through the letters of the given line
      charindex = abc.indexOf(contentArray[i][j]);
      if (contentArray[i][j] === ' ' || contentArray[i][j] === '*') {
        tempString += contentArray[i][j];
      } else {
        tempString += abc.charAt(charindex - 1);
      }
    }
    // console.log(tempString);
    decryptedString += tempString + '\n';
  }
  return decryptedString;
}

console.log(decrypt(fileContent));