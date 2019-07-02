'use strict';

const students: any[] = [
  { name: 'Theodor', age: 3, candies: 2 },
  { name: 'Paul', age: 9.5, candies: 2 },
  { name: 'Mark', age: 12, candies: 5 },
  { name: 'Peter', age: 7, candies: 3 },
  { name: 'Olaf', age: 12, candies: 7 },
  { name: 'George', age: 10, candies: 1 }
];

// create a function that takes a list of students and logs: 
// - How many candies are owned by students altogether
function sumOfCandies(studentsList) {
  let sum: number = 0;
  studentsList.forEach(function (object, index) {
    sum += object.candies;
  });
  return sum;
}
console.log('Sum of candies: ' + sumOfCandies(students));

// create a function that takes a list of students and logs:
// - The sum of the age of people who have less than 5 candies
function sumOfAges(studentsList, maxCandies: number): number {
  let sum: number = 0;
  studentsList.forEach(function (object, index) {
    if (object.candies < maxCandies) {
      sum += object.age;
    }
  });
  return sum;
}
console.log('Sum of ages, where candy is less, than 5: ' + sumOfAges(students, 5));