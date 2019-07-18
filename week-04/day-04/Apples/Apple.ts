'use strict';

class Apple {
  getApple() {
    return 'apple';
  }

  sum(ints: number[]): number {
    let summary: number = 0;
    ints.forEach(element => {
      summary += element;
    });
    return summary;
  }

  anagramChecker(str1: string, str2: string) {
    let str2Reversed = str2.split('').reverse().join('');
    // console.log(str2.split('').reverse());
    return str1 === str2Reversed;
    // return str2Reversed;
  }

  charDictionary(str: string) {
    var letterCounter = {};
    for (let i: number = 0; i < str.length; i++) {
      if(Object.keys(letterCounter).indexOf(str[i])>-1) {
        letterCounter[str[i]]++;
      } else {
        letterCounter[str[i]] = 1;
      }
    }
    return letterCounter;

  }
}

let apple: Apple = new Apple();
console.log(apple.anagramChecker('abc', 'cba'));

export { Apple };