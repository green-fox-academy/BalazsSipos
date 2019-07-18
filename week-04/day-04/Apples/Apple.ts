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
}

let apple: Apple = new Apple();
console.log(apple.anagramChecker('abc', 'cba'));

export { Apple };