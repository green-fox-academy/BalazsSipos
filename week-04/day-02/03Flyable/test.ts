'use strict';

import { Helicopter } from './Helicopter';

let heli = new Helicopter('blue', 6, 0, 2);
console.log(heli);
console.log(heli.land());
console.log(heli.fly());
console.log(heli.takeoff());