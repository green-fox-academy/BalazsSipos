'use strict';

import { Animal } from "./Animal";

abstract class BreedWithOwn extends Animal {
  breed() {
    return 'pushing miniature versions out';
  }
}

export { BreedWithOwn };