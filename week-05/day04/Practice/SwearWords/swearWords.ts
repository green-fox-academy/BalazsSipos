'use strict';
declare function require(path: string): any;
const fs = require('fs');
let changedWordCounter: number = 0; 

function readContent(fileName: string): string {
  try {
    return fs.readFileSync(fileName, 'utf-8');
  } catch (error) {
    console.log('File cannot be accessed!');
    return undefined;
  }
}

function iterateSwearWords(fileName: string): void {
  const swearWords: string[] = ['fucker', 'bloody', 'cock', 'shit', 'fUck', 'fuckstick', 'asshole', 'dick', 'piss', 'cunt'];
  
  let content: string = readContent('./' + fileName);
  
  content = content.toLocaleLowerCase();
  
  swearWords.forEach(swearWord => {
    content = filterOutSwearWorld(content, swearWord.toLocaleLowerCase());
  });
}

// Write a method which can read and parse a file containing not so family friendly text. The method must remove all the given words from the file and return the amount of the removed words.
function filterOutSwearWorld(inputString: string, swearWord: string): string {
  let index: number;
  index = inputString.indexOf(swearWord);
  while(index !== -1) {
    inputString = inputString.substr(0,index) + inputString.substr(index + swearWord.length);
    index = inputString.indexOf(swearWord);
    changedWordCounter++;
  }
  return inputString;
}

iterateSwearWords('input2.txt');
console.log(changedWordCounter);

export { filterOutSwearWorld };
export { iterateSwearWords };
export { readContent };