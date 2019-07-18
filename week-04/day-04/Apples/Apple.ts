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

  palindromChecker(str1: string, str2: string) {
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

  fibonacci(nmb: number) {
    if (nmb === 1) {
      return 0;
    } else if(nmb === 2) {
      return 1;
    } else {
      return this.fibonacci(nmb-1) + this.fibonacci(nmb-2);
    }
  }
}

// let apple: Apple = new Apple();
// console.log(apple.anagramChecker('abc', 'cba'));

export { Apple };