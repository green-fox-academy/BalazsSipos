'use strict';

import { Plant } from './Plant';

class Flower extends Plant {
  isNeedsWatering() {
    if (this.waterLevel < 5) {
      this.needsWater = true;
    } else {
      this.needsWater = false;
    }
  }

  watering(waterAmount: number) {
    this.waterLevel += waterAmount * 0.75;
    this.isNeedsWatering();
  }
}

export { Flower };