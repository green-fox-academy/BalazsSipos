'use strict';
// Create a function that prints the ingredient list of dictionaries to the console in the following format:
//
// +--------------------+---------------+----------+
// | Ingredient         | Needs cooling | In stock |
// +--------------------+---------------+----------+
// | vodka              | Yes           | 1        |
// | coffee_liqueur     | Yes           | -        |
// | fresh_cream        | Yes           | 1        |
// | captain_morgan_rum | Yes           | 2        |
// | mint_leaves        | No            | -        |
// +--------------------+---------------+----------+
//
// OPTIONAL
// The frist columns should be automatically as wide as the longest key

const ingredients: any[] = [
  { name: 'vodka', inStock: 1, needsCooling: true },
  { name: 'coffee_liqueur', inStock: 0, needsCooling: true },
  { name: 'fresh_cream', inStock: 1, needsCooling: true },
  { name: 'captain_morgan_rum', inStock: 2, needsCooling: true },
  { name: 'mint_leaves', inStock: 0, needsCooling: false },
  { name: 'sugar', inStock: 0, needsCooling: false },
  { name: 'lime juice', inStock: 0, needsCooling: true },
];

// Calculate the length of the longest ingredient name
let longestIngredientName: number = 0;
ingredients.forEach(function (tempObject, index) {
  if (tempObject.name.length > longestIngredientName) {
    longestIngredientName = tempObject.name.length;
  }
});
console.log(longestIngredientName);

let characterCollector: string = '';
function printCharacters(character: string, numberOfDashes: number) {
  characterCollector = '';
  for (let i: number = 1; i <= numberOfDashes; i++) {
    characterCollector += character;
  }
  return characterCollector;
}

console.log('+' + printCharacters('-', longestIngredientName + 2) + '+' + printCharacters('-', 15) + '+' + printCharacters('-', 10) + '+');
console.log('| Ingredient         | Needs cooling | In stock |');
console.log('+' + printCharacters('-', longestIngredientName + 2) + '+' + printCharacters('-', 15) + '+' + printCharacters('-', 10) + '+');

// Prints the body of the table
function printIngredients(ingredientsObject) {
  let rowStringCollector: string = '';
  ingredientsObject.forEach(function (tempObject, indexOfObject) {
    rowStringCollector = '';
    rowStringCollector += '| ' + tempObject.name;
    rowStringCollector += printCharacters('-', longestIngredientName - tempObject.name.length);
    rowStringCollector += ' | ' + tempObject.needsCooling ? 'Yes' : 'No';
    rowStringCollector += printCharacters('-', tempObject.needsCooling ? 10 : 11);
    console.log(rowStringCollector);
  });
}

printIngredients(ingredients);