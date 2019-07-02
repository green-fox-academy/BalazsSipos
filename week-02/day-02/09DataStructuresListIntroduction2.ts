'use strict';

let lists = {
  'list A': ['Apple', 'Avocado', 'Blueberries', 'Durian', 'Lychee']
};

// Create a new list ('List B') with the values of List A
lists['list B'] = lists['list A'].slice();

// Print out whether List A contains Durian or not
console.log('Durian is in the list? ' + (lists["list A"].indexOf('Durian') >= 0));

// Remove Durian from List B
let indexOfDurian = lists['list B'].indexOf('Durian');
lists['list B'].splice(indexOfDurian, 1);

// Add Kiwifruit to List A after the 4th element
lists['list A'].splice(4, 0, 'Kiwifruit');

// Compare the size of List A and List B
if (lists['list A'].length > lists['list B'].length) {
  console.log('List A is longer');
} else if (lists['list A'].length < lists['list B'].length) {
  console.log('List B is longer');
} else {
  console.log('List A is the same length as List B');
}

// Get the index of Avocado from List A
console.log('Index of Avocado in List A: ' + lists['list A'].indexOf('Avocado'));

// Get the index of Durian from List B
console.log('Index of Durian in List B: ' + lists['list B'].indexOf('Durian'));

// Add Passion Fruit and Pomelo to List B in a single statement
lists['list B'].push('Passion Fruit', 'Pomelo');

// Print out the 3rd element from List A
console.log('Third element of List A: ' + lists['list A'][2]);

console.log(lists);