'use strict';

// Create an Animal class
// Every animal has a hunger value, which is a whole number
// Every animal has a thirst value, which is a whole number
// when creating a new animal object these values are created with the default 50 value
// Every animal can eat() which decreases their hunger by one
// Every animal can drink() which decreases their thirst by one
// Every animal can play() which increases both by one

class Animal {
  hunger: number;
  thirst: number;

  constructor(hung: number = 50, thir: number = 50) {
    this.hunger = hung;
    this.thirst = thir;
  }

  eat(): void {
    if (this.hunger !== 0) {
      this.hunger--;
    }
  }

  drink(): void {
    if (this.thirst !== 0) {
      this.thirst--;
    }
  }

  play(): void {
    if (this.hunger !== 50) {
      this.hunger++;
    }
    if (this.thirst !== 50) {
      this.thirst++;
    }
  }
}

export { Animal };

let animal = new Animal();

console.log(animal);