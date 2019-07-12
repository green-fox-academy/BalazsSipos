'use strict';

// Given a string, compute recursively a new string where all the 'x' chars have been removed.

function strings(str: string): string {
  if (str.length === 1) {
    if (str === 'x') {
      return '';
    } else {
      return str;
    }
  } else {
    if (str.slice(0, 1) === 'x') {
      return strings(str.slice(1));
    } else {
      return str.slice(0, 1) + strings(str.slice(1));
    }
  }
}

console.log(strings('xalma'));
console.log(strings('xyzxd'));