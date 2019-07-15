'use strict';

import { Flower } from './Flower';
import { Tree } from './Tree';
import { Garden } from './Garden';

// Have the basic garden object
let gardenApp = new Garden();

// Show the starting state
console.log('Empty garden object----------------------');
gardenApp.analyseGarden();

// Create the 2 flowers and the 2 trees
gardenApp.addPlants(new Flower('blue'));
gardenApp.addPlants(new Flower('blue'));
gardenApp.addPlants(new Tree('purple'));
gardenApp.addPlants(new Tree('orange'));

// Check the status
console.log('Filled garden object----------------------');
gardenApp.analyseGarden();

// Water with 40
gardenApp.waterGarden(40);
console.log('After water with 40----------------------');
gardenApp.analyseGarden();

// Water with 70
gardenApp.waterGarden(70);
console.log('After water with 70----------------------');
gardenApp.analyseGarden();