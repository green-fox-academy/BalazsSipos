'use strict';

let prices = {
  'Milk': 1.07,
  'Rice': 1.59,
  'Eggs': 3.14,
  'Cheese': 12.60,
  'Chicken Breasts': 9.40,
  'Apples': 2.31,
  'Tomato': 2.58,
  'Potato': 1.75,
  'Onion': 1.10
}

let bob = {
  'Milk': 3,
  'Rice': 2,
  'Eggs': 2,
  'Cheese': 1,
  'Chicken Breasts': 4,
  'Apples': 1,
  'Tomato': 2,
  'Potato': 1
}

let alice = {
  'Rice': 1,
  'Eggs': 5,
  'Chicken Breasts': 2,
  'Apples': 1,
  'Tomato': 10
}

// How much does Bob pay?
let bobTotal: number = 0;
Object.keys(bob).forEach(function (key) {
  bobTotal += bob[key] * prices[key];
});

console.log('Bob bought for ' + bobTotal);

// How much does Alice pay?
let aliceTotal: number = 0;
Object.keys(alice).forEach(function (key) {
  aliceTotal += alice[key] * prices[key];
});

console.log('Alice bought for ' + aliceTotal);

function whoBuysMore(product) {
  let bobProduct: number = 0;
  let aliceProduct: number = 0;
  if (bob[product]) {
    bobProduct = bob[product];
  } else {
    bobProduct = 0;
  }

  if (alice[product]) {
    aliceProduct = alice[product];
  } else {
    aliceProduct = 0;
  }

  if (bobProduct > aliceProduct) {
    console.log('Bob bought more ' + product);
  } else if (bobProduct < aliceProduct) {
    console.log('Alice bought more ' + product);
  } else {
    console.log('They bought the same amount of ' + product);
  }
}

// Who buys more Rice?
whoBuysMore('Rice');

// Who buys more Potato?
whoBuysMore('Potato');

// Who buys more different products?
function sumProductType(person) {
  let productTypes: number = Object.keys(person).length;
  console.log(person + ' bought ' + productTypes + ' different products.');
}

sumProductType('bob');
sumProductType('alice');
// let bobProductTypes: number = Object.keys(bob).length;
// let aliceProductTypes: number = Object.keys(alice).length;
// console.log('Alice bought ' + aliceProductTypes + ' different products.');

// Who buys more products? (piece)
function sumProductPiece(person: object, personName: string) {
  let productPiece: number = 0;
  Object.keys(person).forEach(function (key) {
    productPiece += person[key];
    // console.log(productPiece);
  });
  console.log(personName + ' bought ' + productPiece + ' pieces of product:');
}

sumProductPiece(bob, 'Bob');
sumProductPiece(alice, 'Alice');