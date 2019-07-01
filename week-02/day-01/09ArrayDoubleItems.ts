'use strict';

// -  Create an array variable named `drinks` with the following content: `['Gin', 'Whiskey', 'Wine', 'Beer']`
let drinks: string[] = ['Gin', 'Whiskey', 'Wine', 'Beer'];
// -  Double all the strings in the array, use a built in array method instead of a loop
let drinksDouble: string[] = drinks.map(function (value) {
  return value + value;
});
// It should print: ['GinGin', 'WhiskeyWhiskey', 'WineWine', 'BeerBeer']`
console.log(drinksDouble);