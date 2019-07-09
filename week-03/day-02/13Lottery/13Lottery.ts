'use strict';

// Create a method that find the 5 most common lottery numbers in lottery.csv

declare function require(path: string): any
const fs = require('fs');

try {
  let lotteryContent: string = fs.readFileSync('lottery.csv', 'utf-8');
  let lotteryArray = lotteryContent.split('\n');
  buildLotteryNumbersArray(lotteryArray);
} catch (e) {
  console.log(e.message);
}

function buildLotteryNumbersArray(lotteryArray: string[]): string[] {
  let lotteryNumbersArray: string[] = [];
  let lotteryNumbersObject = {};
  let line: string[] = [];
  let counter: number = 1;

  lotteryArray.forEach(function (value, index) {
    line = value.split(';');
    for (let i: number = line.length - 1; i >= line.length - 5; i--) {
      lotteryNumbersArray.push(line[i].replace('\r', ''));
      if (lotteryNumbersObject.hasOwnProperty(line[i].replace('\r', ''))) {
        lotteryNumbersObject[line[i].replace('\r', '')]++;
      } else {
        lotteryNumbersObject[line[i].replace('\r', '')] = 1;
      }
    }
    counter++;
  });

  // ---------------------------------------------------------------------------------------------
  // FINAL STEP IS MISSING
  // This is the object with the lottery numbers and their frequency, they just have to be ordered
  console.log(lotteryNumbersObject);
  return line;
}