'use strict';

import { StringedInstrument } from "./StringedInstrument";

class Violin extends StringedInstrument {
  constructor(numberOfStrings?: number) {
    super(numberOfStrings);
    this.numberOfStrings = 4;
    this.name = 'Violin';
  }

  sound(): string {
    return 'Screech';
  }
}

export { Violin };