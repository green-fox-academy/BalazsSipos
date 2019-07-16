'use strict';

interface Flyable {
  takeoffLength: number;
  land();
  fly();
  takeoff();
}

export { Flyable };