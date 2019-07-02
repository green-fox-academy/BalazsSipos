'use strict';
// Accidentally I messed up this quote from Richard Feynman.
// Two words are out of place
// Your task is to fix it by swapping the right words with code

// Also, log the sentence to the console with spaces in between.
// Create a function called quoteSwap().

let words: string[] = ['What', 'I', 'do', 'create,', 'I', 'cannot', 'not', 'understand.'];

function quoteSwap(list: string[]): string {
  list.splice(2, 1, 'cannot');
  list.splice(5, 1, 'do');
  return list.join(' ');
}

console.log(quoteSwap(words));
// Expected output: "What I cannot create I do not understand."

export = quoteSwap;