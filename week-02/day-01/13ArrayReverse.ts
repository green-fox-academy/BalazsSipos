'use strict';

// -  Create a variable named `numList`
//    with the following content: `[3, 4, 5, 6, 7]`
let numList: number[] = [3, 4, 5, 6, 7];
let numList2: number[] = [3, 4, 5, 6, 7];
console.log(numList);

// -  Reverse the order of the elements in `numList`
// 	   -  do it with the built in method
numList.reverse();
console.log(numList);

//	   -  do it with creating a new temp array and a loop
let reverseNumList: number[] = [];
for (let i: number = 0; i < numList2.length; i++) {
  reverseNumList[numList2.length - 1 - i] = numList2[i];
}
// -  Print the elements of the reversed `numList`
console.log(reverseNumList);