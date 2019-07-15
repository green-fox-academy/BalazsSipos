'use strict';

import { F16 } from './F16';
import { F35 } from './F35';

class Carrier {
  aircrafts: F16[] | F35[] = [];
  ammoStored: number;
  carrierHealth: number;

  constructor(ammoStored: number = 500, carrierHealth: number = 2000) {
    this.ammoStored = ammoStored;
    this.carrierHealth = carrierHealth;
  }

  add(...aircraft: F16[] | F35[]): void {
    this.aircrafts.push(...aircraft);
  }

  // Fills the plane, if its priority is the same as the input parameter
  fill(isPriority: boolean) {
    this.aircrafts.forEach(element => {
      if (element.priority === isPriority) {
        try {
          // If there is not enough ammo in the carrier to fill the given plane
          if (this.ammoStored < (element.maxAmmo - element.currentAmmo)) {
            throw 'There is not enough ammo in the carrier to fill current plane.';
          } else {
            this.ammoStored -= element.maxAmmo - element.currentAmmo;
            element.currentAmmo = element.maxAmmo;
          }
        } catch (error) {
          return error;
        }
      }
    });
  }

  fight(otherCarrier: Carrier): number {
    let damageSum: number = 0;
    this.aircrafts.forEach(element => {
      damageSum += element.fight();
    });

    if (otherCarrier.carrierHealth < damageSum) {
      otherCarrier.carrierHealth = 0;
    } else {
      otherCarrier.carrierHealth = otherCarrier.carrierHealth - damageSum;
    }
    return damageSum;
  }

  getStatus(): string {
    let carrierdetails: string = '';

    if (this.carrierHealth === 0) {
      return 'It\'s dead Jim :(';
    } else {
      carrierdetails += `HP: ${this.carrierHealth}`;
      carrierdetails += `, Aircraft count: ${this.aircrafts.length}`;
      carrierdetails += `, Ammo storage: ${this.ammoStored}`;
      carrierdetails += `, Total damage: ${this.calculateTotalDamage()}`;
      carrierdetails += '\n';
      carrierdetails += 'Aircrafts:';
      carrierdetails += '\n';

      this.aircrafts.forEach(element => {
        carrierdetails += `Type: ${element.getType()}`;
        carrierdetails += `, Ammo: ${element.currentAmmo}`;
        carrierdetails += `, Base Damage: ${element.baseDamage}`;
        carrierdetails += `, All Damage: ${element.currentDamage()}`;
        carrierdetails += '\n';
      });

      return carrierdetails;
    }
  }

  calculateTotalDamage(): number {
    let damageSum: number = 0;
    this.aircrafts.forEach(element => {
      damageSum += element.currentDamage();
    });
    return damageSum;
  }
}

export { Carrier };