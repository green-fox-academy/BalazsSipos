'use strict';

import { Aircraft } from './Aircraft';

class F35 extends Aircraft {
  constructor() {
    super();
    this.maxAmmo = 12;
    this.baseDamage = 50;
    this.priority = true;
    this.className = 'F35';
  }
}

export { F35 };