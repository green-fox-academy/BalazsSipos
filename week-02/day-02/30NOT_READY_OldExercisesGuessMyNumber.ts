'use strict';

// console.log('I\'ve the number between 1-100. You have 5 lives. Try to guess it!');

const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

// readline.question('I\'ve the number between 1-100. You have 5 lives. Try to guess it!', (guess) => {
//   console.log(`Hi ${guess}!`);
//   // readline.close()
// })
let randomNumber: number = Math.floor(Math.random() * 101);
console.log(randomNumber);

// function read(textToWrite: string) {
//   readline.question(textToWrite, (inputFromUser) => {
    
//   })
// }

// readline.question('I\'ve the number between 1-100. You have 5 lives. Try to guess it!', (guess) => {
//   console.log('Your guess is: ' + guess);
//   if(guess == randomNumber) {
//     console.log('Congrat, you guessed it right!');

//   } else if (guess > randomNumber) {
//     console.log('Too high. You have 4 lives left.');
//   }
//   readline.question('What2', (guess2) => {
//     console.log(`Hi ${guess2}!`);
//     readline.close()
//   })
// })

function comm(comment: string) {
  let end: boolean = false;

  console.log(end);
  readline.question(comment, (guess) => {
    // console.log(randomNumber);
    console.log('Your guess is: ' + guess);
    if(guess === randomNumber) {
      console.log('Congrat, you guessed it right!');
      end = true;
      readline.close();
    } else if (guess > randomNumber) {
      console.log('Too high. You have 4 lives left.');
    }
  });
  console.log(end);
  if(!end) {
    readline.question('What2', (guess2) => {
      console.log(`Hi ${guess2}!`);
      readline.close()
    });
  }
}

comm('I\'ve the number between 1-100. You have 5 lives. Try to guess it!');

const args = process.argv.splice(2); // Just a helper for you to get started
// console.log(args);