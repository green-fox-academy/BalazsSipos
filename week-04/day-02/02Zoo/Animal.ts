'use strict';

abstract class Animal {
  name: string;
  age: number = 0;
  gender: string;
  color: string;
  height: number;
  constructor(name: string, gender: string, color: string, height: number) {
    this.name = name;
    this.gender = gender;
    this.color = color;
    this.height = height;
  }

  getName() {
    return this.name;
  }

  abstract breed();
}

export { Animal };