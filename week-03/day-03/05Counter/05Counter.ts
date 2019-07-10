'use string';

// Create a Counter class
// which has an integer property
// when creating it should have a default value 0 or we can specify it when creating
// we can add(number) to increase the counter's value by a whole number
// or we can add() without parameters just increasing the counter's value by one
// and we can get() the current value as string
// also we can reset() the value to the initial value

class Counter {
  counter: number;
  initialValue: number;

  constructor(counter: number = 0) {
    this.counter = counter;
    this.initialValue = counter;
  }

  add(num: number = 1) {
    this.counter += num;
  }

  get() {
    return this.counter.toString();
  }

  reset() {
    this.counter = this.initialValue;
  }
}

// Two objects
let counter1: Counter = new Counter();
let counter2: Counter = new Counter(20);

// Check the initial states
console.log(counter1);
console.log(counter2);

// Check add methods
counter2.add();
console.log(counter2);

counter2.add(20);
console.log(counter2);

// Check get method
console.log(counter2.get());
console.log(typeof counter2.get());

// Check reset method
counter2.reset();
console.log(counter2);
