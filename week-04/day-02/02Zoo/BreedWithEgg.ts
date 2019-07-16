'use strict';

import { Animal } from "./Animal";

abstract class BreedWithEgg extends Animal {
  breed() {
    return 'laying eggs';
  }
}

export { BreedWithEgg };