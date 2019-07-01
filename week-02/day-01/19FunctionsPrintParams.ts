'use strict';

// -  Create a function called `printParams`
//    which logs to the console the input parameters
//    (can have multiple number of arguments)
function printParams(inputParam1: string, ...inputParams: string[]) {
  console.log(inputParam1);
  for (let i: number = 0; i < inputParams.length; i++) {
    console.log(inputParams[i]);
  }
}

printParams('Test1', 'Test2', 'Test3', 'Test4');