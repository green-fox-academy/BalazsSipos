'use strict';

// -  Create (dynamically*) a two dimensional list
//    with the following matrix**. Use a loop!
//
//    0 0 0 1
//    0 0 1 0
//    0 1 0 0
//    1 0 0 0
//
let dimension: number = 8;
let matrix: any[] = [];
for (let i: number = 1; i <= dimension; i++) {
  matrix[i - 1] = [];
  for (let j: number = 1; j <= dimension; j++) {
    if (i + j - 1 == dimension) {
      matrix[i - 1][j - 1] = 1;
    } else {
      matrix[i - 1][j - 1] = 0;
    }
  }
  console.log(matrix[i - 1].join(" "));
}
// -  Print this two dimensional list to the console

// * size should depend on a variable
// ** Relax, a matrix is just like an array