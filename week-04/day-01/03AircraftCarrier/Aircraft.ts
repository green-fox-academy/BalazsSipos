'use strict';

class Aircraft {
  maxAmmo: number;
  baseDamage: number;
  currentAmmo: number = 0;
  priority: boolean = false;
  className: string = '';

  fight(): number {
    const damage: number = this.currentDamage();
    this.currentAmmo = 0;
    return damage;
  }

  refill(ammoAvailable: number): number {
    const ammoFilled = Math.min((this.maxAmmo - this.currentAmmo), ammoAvailable);
    this.currentAmmo += ammoFilled;
    return ammoAvailable - ammoFilled;
  }

  getType(): string {
    return this.className;
  }

  getStatus(): string {
    return `Type ${this.getType}, Ammo: ${this.currentAmmo}, Base Damage: ${this.baseDamage}, All Damage: ${this.currentAmmo} * ${this.baseDamage}.`
  }

  isPriority() {
    return this.priority;
  }

  currentDamage(): number {
    return this.currentAmmo * this.baseDamage;
  }
}

export { Aircraft };