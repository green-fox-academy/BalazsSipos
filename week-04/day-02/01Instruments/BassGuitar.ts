'use strict';

import { StringedInstrument } from "./StringedInstrument";

class BassGuitar extends StringedInstrument {
  constructor(numberOfStrings: number = 4) {
    super(numberOfStrings);
    this.name = 'Bass Guitar';
  }

  sound(): string {
    return 'Duum-duum-duum';
  }
}

export { BassGuitar };