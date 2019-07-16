'use strict';

import { StringedInstrument } from "./StringedInstrument";

class ElectricGuitar extends StringedInstrument {
  constructor(numberOfString: number = 6) {
    super(numberOfString);
    this.name = 'Electric Guitar';
  }

  sound(): string {
    return 'Twang';
  }
}

export { ElectricGuitar };