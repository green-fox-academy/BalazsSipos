// ORIGINAL COMMENT
// An Armstrong number is an n-digit number that is equal to the sum of the nth powers of its digits.

// Let's demonstrate this for a 4-digit number: 1634 is a 4-digit number, raise each digit to the fourth power, and add: 1^4 + 6^4 + 3^4 + 4^4 = 1634, so it is an Armstrong number.
// For a 3-digit number: 153 is a 3-digit number, raise each digit to the third power, and add: 1^3 + 5^3 + 3^3 = 153, so it is an Armstrong number.

// EXERCISE
// Write a simple program to check if a given number is an armstrong number. The program should ask for a number. E.g. if we type 371, the program should print out: The 371 is an Armstrong number.

function isArmstrongNumber(numberToCheck: number) {
  let numberAsString: string;
  numberAsString = numberToCheck.toString();

  let sum = 0;
  for (let i: number = 0; i < numberAsString.length; i++) {
    sum += Number(numberAsString[i]) ** numberAsString.length;
  }

  if (sum === numberToCheck) { // check if it is an Armstrong number
    console.log(sum);
  }
}

// Check all numbers till 200 000
for (let i: number = 1; i <= 200000; i++) {
  isArmstrongNumber(i);
}