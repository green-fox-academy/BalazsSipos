'use strict';

abstract class Instrument {
  protected name: string;
  abstract play(): void;
}

export { Instrument };