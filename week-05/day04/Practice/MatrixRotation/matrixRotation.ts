'use strict';

function rotateMatrix(inputMatrix: number[][], direction: string = 'right') {
  if(inputMatrix === undefined) {
    console.log('Please provide input matrix');
  }
  if(inputMatrix === []) {
    console.log('Please provide non-empty matrix');
  }
  for (let i: number = 0; i < inputMatrix.length; i++) {
    if(inputMatrix[i].length !== inputMatrix.length) {
      console.log('Please provide symmetrical matrix');
    }
  }

  let outputMatrix: number[][] = []; // clockwise
  let outputMatrix2: number[][] = []; // anti-clockwise
  let tempMatrix: number[] = [];
  for (let i: number = 0; i < inputMatrix.length; i++) {
    outputMatrix[i] = [];
    outputMatrix2[i] = [];
    for (let j: number = 0; j < inputMatrix[i].length; j++) {
      outputMatrix[i].push(inputMatrix[inputMatrix.length-j-1][i]);
      outputMatrix2[i].push(inputMatrix[j][inputMatrix.length-i-1]);
    }
  }
  console.log(outputMatrix);
  console.log(outputMatrix2);


}

rotateMatrix([[1,2,3],[4,5,6],[7,8,9]]);
rotateMatrix([[1,2,3,4],[5,6,7,8],[1,3,5,7],[2,4,6,8]]);
