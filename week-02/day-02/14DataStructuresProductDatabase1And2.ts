'use strict';

let products = {
  'Eggs': 200,
  'Milk': 200,
  'Fish': 400,
  'Apples': 150,
  'Bread': 50,
  'Chicken': 550
}

// How much is the fish?
console.log('Fish is ' + products['Fish']);

// What is the most expensive product?
// let highest: number = Math.max(Object.values(products));
let valuesList: number[] = [];
Object.keys(products).forEach(function (key) {
  valuesList.push(products[key]);
});

console.log(Object.keys(products));

console.log('Most expensive is ' + (Object.keys(products)[valuesList.indexOf(Math.max(...valuesList))]));

// What is the average price?
let sum: number = 0;
valuesList.forEach(function (value) {
  sum += value;
});
console.log('Average is ' + Math.round(sum / valuesList.length));

// How many products' price is below 300?
let counter: number = 0;
valuesList.forEach(function (value) {
  if (value < 300) {
    counter++;
  }
});
console.log('Number of items under 300: ' + counter);

// Is there anything we can buy for exactly 125?
if (valuesList.indexOf(125) > 0) {
  console.log('We have an item for 125');
} else {
  console.log('We do not have an item for 125');
}

// What is the cheapest product?
console.log('Least expensive is ' + (Object.keys(products)[valuesList.indexOf(Math.min(...valuesList))]));

// Which products cost less than 201? (just the name)
// Which products cost more than 150? (name + price)
let cheapProducts: string[] = [];
let expProducts = {};

Object.keys(products).forEach(function (key) {
  if (products[key] < 201) {
    cheapProducts.push(key);
  }
  if (products[key] > 150) {
    expProducts[key] = products[key];
  }
});
console.log('Cheaper, than 201: ' + cheapProducts);
console.log('Costs more, than 150: ');
Object.keys(expProducts).forEach(function (key) {
  console.log(key + ' ' + products[key]);
});

console.log(products);