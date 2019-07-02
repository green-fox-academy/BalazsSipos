'use strict';

// Create a list with the following items.
// Eggs, milk, fish, apples, bread and chicken
let shopingList: string[] = ['eggs', 'milk', 'fish', 'apples', 'bread', 'chicken'];

function itemChecker(itemName: string) {
  if(shopingList.indexOf(itemName)>0) {
    console.log('We have ' + itemName + ' on the list');
  } else {
    console.log('We do not have ' + itemName + ' on the list');
  }
}

// Do we have milk on the list?
itemChecker('milk');

// Do we have bananas on the list?
itemChecker('bananas');