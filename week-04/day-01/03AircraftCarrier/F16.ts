'use strict';

import { Aircraft } from './Aircraft';

class F16 extends Aircraft {
  constructor() {
    super();
    this.maxAmmo = 8;
    this.baseDamage = 30;
    this.className = 'F16';
  }
}

export { F16 };