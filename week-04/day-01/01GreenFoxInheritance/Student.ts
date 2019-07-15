'use strict';

import { Person } from './Person';

class Student extends Person {
  previousOrganization: string;
  skippedDays: number = 0;

  constructor(name: string = 'Jane Doe', age: number = 30, gender: string = 'female', previousOrganisation: string = 'The School of Life') {
    super(name, age, gender);
    this.previousOrganization = previousOrganisation;
  }

  introduce(): void {
    console.log(`Hi, I\'m ${this.name}. a ${this.age} year old ${this.gender} from ${this.previousOrganization}, who skipped ${this.skippedDays} from the course already.`);
  }

  getGoal(): void {
    console.log('My goal is: Be a junior software developer.');
  }

  skipDays(numberOfDays: number) {
    this.skippedDays += numberOfDays;
  }
}

export { Student };