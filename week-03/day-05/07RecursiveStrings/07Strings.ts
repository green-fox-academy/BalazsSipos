'use strict';

// Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.

function strings(str: string): string {
  if (str.length === 1) {
    if (str === 'x') {
      return 'y';
    } else {
      return str;
    }
  } else {
    if (str.slice(0, 1) === 'x') {
      return 'y' + strings(str.slice(1));
    } else {
      return str.slice(0, 1) + strings(str.slice(1));
    }
  }
}

console.log(strings('xalma'));
console.log(strings('xyzxd'));