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
}

export { Apple };