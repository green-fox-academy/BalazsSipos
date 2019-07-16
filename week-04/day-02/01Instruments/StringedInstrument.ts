'use strict';

import { Instrument } from "./Instrument";

abstract class StringedInstrument extends Instrument {
  numberOfStrings: number;

  constructor(numberOfStrings?: number) {
    super();
    this.numberOfStrings = numberOfStrings;
  }

  abstract sound(): void;

  play(): void {
    console.log(`${this.name}, a ${this.numberOfStrings}-stringed instrument, that goes ${this.sound()}`);
  }
}

export { StringedInstrument };