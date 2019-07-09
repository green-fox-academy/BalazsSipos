'use strict';

// Create a method that decrypts duplicated-chars.txt

declare function require(path: string): any
const fs = require('fs');

try {
  let fileContent: string = fs.readFileSync('duplicated-chars.txt', 'utf-8');
  console.log(decrypt(fileContent));
} catch (e) {
  console.log(e.message);
}

function decrypt(content: string): string {
  let decryptedString: string = '';
  for (let i: number = 0; i < content.length; i++) {
    if (i % 2 === 1) {
      decryptedString += content[i];
    }
  }
  return decryptedString;
}