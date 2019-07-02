'use strict';

// Create an empty list which will contain names (strings)
let list = {
  names: []
};
// Print out the number of elements in the list
console.log(list);
// Add William to the list
list.names.push("William");
// Print out whether the list is empty or not
console.log(list.names);
// Add John to the list
list.names.push("John");
// Add Amanda to the list
list.names.push("Amanda");
// Print out the number of elements in the list
console.log('Number of elements: ' + list.names.length);
// Print out the 3rd element
console.log('3rd name: ' + list.names[2]);
// Iterate through the list and print out each name
list.names.forEach(function (value) {
  console.log(value);
});
// Iterate through the list and print
list.names.forEach(function (value, index) {
  console.log(index + 1 + '. ' + value);
});
// Remove the 2nd element
let removed = list.names.splice(1,1);
// Iterate through the list in a reversed order and print out each name
list.names.reverse().forEach(function(value){
  console.log(value);
});
// Remove all elements
let removedAll = list.names.splice(0,2);
console.log(list.names);