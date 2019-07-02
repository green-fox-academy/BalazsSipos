'use strict';

// Create an empty map where the keys are integers and the values are characters
let maps = {

}
// Print out whether the map is empty or not
console.log(maps);
// Add the following key-value pairs to the map
maps[97] = 'a';
maps[98] = 'b';
maps[99] = 'c';
maps[65] = 'A';
maps[66] = 'B';
maps[67] = 'C';
console.log(maps);
// Print all the keys
console.log(Object.keys(maps));
// Print all the values
// tsconfig.json is not set up  to use ed2017, so it does not work currently
//console.log(Object.values(maps));

// Add value D with the key 68
maps[68] = 'D';
// Print how many key-value pairs are in the map
console.log('Number of key-value pairs: ' + Object.keys(maps).length);
// Print the value that is associated with key 99
console.log('value with key 99: ' + maps[99]);
// Remove the key-value pair where with key 97
console.log(maps);
delete maps[97];
console.log(maps);
// Print whether there is an associated value with key 100 or not
console.log('Key 100 exists? ' + maps.hasOwnProperty(100));
// Remove all the key-value pairs
delete maps[65];
delete maps[66];
delete maps[67];
delete maps[68];
delete maps[98];
delete maps[99];
console.log(maps);