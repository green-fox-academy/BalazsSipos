'use strict';

// Read all data from 'log.txt'.
// Each line represents a log message from a web server
// Write a function that returns an array with the unique IP adresses.
// Write a function that returns the GET / POST request ratio.

declare function require(path: string): any
const fs = require('fs');

try {
  let logContent: string = fs.readFileSync('log.txt', 'utf-8');
  let logArray = logContent.split('\n');
  let IPsArrayG: string[] = buildIPArrays(logArray);
  let GetPostRatioG: string = GetPostRatio(logArray);
  console.log(IPsArrayG.length);
  console.log(GetPostRatioG);
} catch (e) {
  console.log(e.message);
}


// Builds up the array of unique IPs
function buildIPArrays(logArray: string[]): string[] {
  let uniqueIPsArray: string[] = [];
  let IP: string;
  logArray.forEach(function (value, index) {
    IP = value.split(' ')[8];
    if (uniqueIPsArray.indexOf(IP) < 0) {
      uniqueIPsArray.push(IP);
    }
  });

  return uniqueIPsArray;
}

// Returns the Get and Post ratio
function GetPostRatio(logArray: string[]): string {
  let getPostArray: string[] = [];
  let get: number = 0;
  let post: number = 0;
  logArray.forEach(function (value, index) {
    if (value.split(' ')[11] === 'GET') {
      get++;
    } else if (value.split(' ')[11] === 'POST') {
      post++;
    }
  });
  return 'Get:Post ratio is: ' + get + ':' + post;
}