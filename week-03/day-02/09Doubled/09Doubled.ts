'use strict';

// Create a method that decrypts duplicated-chars.txt

declare function require(path: string): any
const fs = require('fs');

let fileContent: string = fs.readFileSync('duplicated-chars.txt', 'utf-8');

function decrypt(content: string): string {
  let decryptedString: string = '';
  for (let i: number = 0; i < content.length; i++) {
    if (i % 2 === 1) {
      decryptedString += content[i];
    }
  }
  return decryptedString;
}

console.log(decrypt(fileContent));