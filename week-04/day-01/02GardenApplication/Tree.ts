'use strict';

import { Plant } from './Plant';

class Tree extends Plant {
  isNeedsWatering() {
    if (this.waterLevel < 10) {
      this.needsWater = true;
    } else {
      this.needsWater = false;
    }
  }

  watering(waterAmount: number) {
    this.waterLevel += waterAmount * 0.4;
    this.isNeedsWatering();
  }
}

export { Tree };