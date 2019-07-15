'use strict';

class Plant {
  waterLevel: number;
  needsWater: boolean;
  color: string;

  constructor(color: string, waterLevel: number = 0, needsWater: boolean = true) {
    this.color = color;
    this.waterLevel = waterLevel;
    this.needsWater = needsWater;
  }
}

export { Plant };