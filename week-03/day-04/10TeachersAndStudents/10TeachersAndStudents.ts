'use strict';

// Create Student and Teacher classes
// Student
// learn() -> prints the student is learning something new
// question(teacher) -> calls the teachers answer method
// Teacher
// teach(student) -> calls the students learn method
// answer() -> prints the teacher is answering a question
// Instantiate a Student and Teacher object
// Call the student's question() method and the teacher's teach() method

class Teacher {
  name: string;

  constructor(tName: string) {
    this.name = tName;
  }

  teach(student: Student): void {
    student.learn();
  }

  answer(): void {
    console.log(this.name + ' is answering a question.');
  }
}

class Student {
  name: string;

  constructor(stName: string) {
    this.name = stName;
  }

  learn() {
    console.log(this.name + ' is learning something new.');
  }

  question(teacher: Teacher) {
    teacher.answer();
  }
}

let student1: Student = new Student('Peter');
let teacher1: Teacher = new Teacher('John');

student1.question(teacher1);
teacher1.teach(student1);