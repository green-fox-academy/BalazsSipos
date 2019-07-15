'use strict';

import { Person } from './Person';

class Sponsor extends Person {
  company: string;
  hiredStudents: number = 0;

  constructor(name: string = 'Jane Doe', age: number = 30, gender: string = 'female', company: string = 'Google') {
    super(name, age, gender);
    this.company = company;
  }

  introduce(): void {
    console.log(`Hi, I\'m ${this.name}. a ${this.age} year old ${this.gender}, who represents ${this.company} and hired ${this.hiredStudents} students so far.`);
  }

  getGoal(): void {
    console.log('My goal is: Hire brilliant junior software developers.');
  }

  hire() {
    this.hiredStudents++;
  }
}

export { Sponsor };