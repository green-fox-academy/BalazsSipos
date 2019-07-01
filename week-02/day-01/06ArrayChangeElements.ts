'use strict';

// -  Create an array named `numList` with the following content: `[1, 2, 3, 8, 5, 6]`
let numlist: number[] = [1, 2, 3, 8, 5, 6];
// -  Change the 8 to 4 with the `.map` method 
let numlistChanged = numlist.map(function (value) {
  if (value == 8) {
    return 4;
  } else {
    return value;
  }
});
// -  Print the fourth element as a test
console.log(numlistChanged);