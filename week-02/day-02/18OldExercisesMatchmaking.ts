'use strict';
// Write a function that joins two array by matching one girl with one boy in a new array
// If someone has no pair, he/she should be the element of the array too
// Exepected output: ["Eve", "Joe", "Ashley", "Fred"...]

let girls: string[] = ['Eve', 'Ashley', 'Claire', 'Kat', 'Jane'];
let boys: string[] = ['Joe', 'Fred', 'Tom', 'Todd', 'Neef', 'Jeff'];

function makingMatches(girls, boys) {
  let pairs: string[] = [];
  let foreachArray = [];
  if (girls.length >= boys.length) {
    foreachArray = girls;
  } else {
    foreachArray = boys;
  }
  foreachArray.forEach(function (value, index) {
    if (typeof (girls[index]) !== 'undefined') {
      pairs.push(girls[index]);
    }
    if (typeof (boys[index]) !== 'undefined') {
      pairs.push(boys[index]);
    }
  });
  return pairs;
}
console.log(makingMatches(girls, boys));

export = makingMatches;