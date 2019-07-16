'use strict';

import { Mammal } from './Mammal'
import { Reptile } from './Reptile'
import { Bird } from './Bird'

let reptile = new Reptile('Crocodile', 'male', 'green', 30);
let mammal = new Mammal("Koala", 'male', 'grey', 70);
let bird = new Bird('Parrot', 'female', 'rainbow', 20);

console.log("How do you breed?");
console.log("A " + reptile.getName() + " is breeding by " + reptile.breed());

// console.log(mammal);
console.log("A " + mammal.getName() + " is breeding by " + mammal.breed());

console.log("A " + bird.getName() + " is breeding by " + bird.breed());

console.log(bird.land());
console.log(bird.fly());
console.log(bird.takeoff());