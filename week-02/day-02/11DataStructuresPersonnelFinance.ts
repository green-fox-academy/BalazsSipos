'use strict';

let expenses: number[] = [500, 1000, 1250, 175, 800, 120];

// How much did we spend?
let total: number = 0;
for (let i: number = 0; i < expenses.length; i++) {
  total += expenses[i];
}
console.log('Total spending: ' + total);

// Which was our greatest expense?
console.log('Greatest expense: ' + Math.max(...expenses));

// Which was our cheapest spending?
console.log('Lowest expense: ' + Math.min(...expenses));

// What was the average amount of our spendings?
console.log('Average expense: ' + Math.round(total / expenses.length));