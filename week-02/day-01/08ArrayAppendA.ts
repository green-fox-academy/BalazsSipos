'use strict';

// -  Create an array variable named `animals`
let animals: string[];
//    with the following content: `["koal", "pand", "zebr"]`
animals = ["koal", "pand", "zebr"]
// -  Add all elements an `"a"` at the end
animals.forEach(function (value, index) {
  animals[index] = value + 'a';
});
console.log(animals);