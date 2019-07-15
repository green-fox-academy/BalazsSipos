'use strict';

import { Person } from './Person';

class Mentor extends Person {
  level: string;

  constructor(name: string = 'Jane Doe', age: number = 30, gender: string = 'female', level: string = 'intermediate') {
    super(name, age, gender);
    this.level = level;
  }

  introduce(): void {
    console.log(`Hi, I\'m ${this.name}. a ${this.age} year old ${this.gender}, ${this.level} level mentor.`);
  }

  getGoal(): void {
    console.log('My goal is: Educate brilliant junior software developers.');
  }
}

export { Mentor };