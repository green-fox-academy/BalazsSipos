'use strict';

import { Carrier } from './Carrier';
import { F16 } from './F16';
import { F35 } from './F35';

let carrier1: Carrier = new Carrier();

// Check empty carrier
console.log(carrier1.getStatus());
console.log('--------------------------------------------');
// Create 4 aircrafts
let f161: F16 = new F16();
let f162: F16 = new F16();
let f351: F16 = new F35();
let f352: F16 = new F35();

// Add them to carrier
carrier1.add(f161, f162, f351, f352);

console.log(carrier1.getStatus());
console.log('--------------------------------------------');

// Fill the aircrafts with ammo for both priority aircrafts and non-priority ones
carrier1.fill(true);
carrier1.fill(false);

console.log(carrier1.getStatus());
console.log('--------------------------------------------');
console.log('--------------------------------------------');
console.log('--------------------------------------------');

// Create an enemy carrier
let carrier2: Carrier = new Carrier();

// Check empty carrier
console.log(carrier2.getStatus());
console.log('--------------------------------------------');
// Create 5 aircrafts
let f163: F16 = new F16();
let f164: F16 = new F16();
let f353: F16 = new F35();
let f354: F16 = new F35();
let f355: F16 = new F35();

// Add them to carrier
carrier2.add(f163, f164, f353, f354, f355);

console.log(carrier2.getStatus());
console.log('--------------------------------------------');

// Fill the aircrafts with ammo for both priority aircrafts and non-priority ones
carrier2.fill(true);
carrier2.fill(false);

console.log(carrier2.getStatus());
console.log('--------------------------------------------');
console.log('--------------------------------------------');
console.log('--------------------------------------------');

// Call fight methods on both carriers
console.log(carrier1.fight(carrier2));
console.log(carrier2.fight(carrier1));
console.log(carrier1.getStatus());
console.log(carrier2.getStatus());