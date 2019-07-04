'use strict';
// console.log('I\'ve the number between 1-100. You have 5 lives. Try to guess it!');
var readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});
// readline.question('I\'ve the number between 1-100. You have 5 lives. Try to guess it!', (guess) => {
//   console.log(`Hi ${guess}!`);
//   // readline.close()
// })
var randomNumber = Math.floor(Math.random() * 101);
console.log(randomNumber);
readline.question('I\'ve the number between 1-100. You have 5 lives. Try to guess it!', function (guess) {
    console.log('Your guess is: ' + guess);
    if (guess == randomNumber) {
        console.log('Congrat, you guessed it right!');
    }
    else if (guess > randomNumber) {
        console.log('Too high. You have 4 lives left.');
    }
    readline.question('What2', function (guess2) {
        console.log("Hi " + guess2 + "!");
        readline.close();
    });
});
var args = process.argv.splice(2); // Just a helper for you to get started
