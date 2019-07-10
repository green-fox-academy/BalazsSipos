'use strict';

// Create Sharpie class
// We should know about each sharpie their color (which should be a string), width (which will be a floating point number), inkAmount (another floating point number)
// When creating one, we need to specify the color and the width
// Every sharpie is created with a default 100 as inkAmount
// We can use() the sharpie objects
// which decreases inkAmount

class Sharpie {
  color: string;
  width: number;
  inkAmount: number = 100;

  constructor(color: string, width: number) {
    this.color = color;
    this.width = width;
  }

  use(amount: number) {
    if (this.inkAmount >= amount) {
      this.inkAmount -= amount;
    } else {
      this.inkAmount = 0;
    }
  }
}

let Obj1: Sharpie = new Sharpie('blue', 20);
console.log(Obj1);

// This works
Obj1.use(20);
console.log(Obj1);

// Ink will be 0 here, not -10
Obj1.use(90);
console.log(Obj1);
