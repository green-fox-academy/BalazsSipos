'use strict';

import { IReservation } from "./ReservationInterface";

class Reservation implements IReservation {
  codeLength: number;
  codeLetterCollector: string;
  dow: string[];
  reservations: string[] = [];

  constructor(codeLength: number = 8, letters: string = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', Dow: string[] = ['MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT', 'SUN']) {
    this.codeLength = codeLength;
    this.codeLetterCollector = letters;
    this.dow = Dow;
  }

  // Gets back one day from the list of days
  getDowBooking(): string {
    return this.getRandomElementFromArray();
  }

  // Gets back the reservation code
  getCodeBooking(): string {
    let codeCollector: string = '';
    for (let i: number = 0; i < this.codeLength; i++) {
      codeCollector += this.getRandomElementFromString();
    }

    return codeCollector;
  }

  // Gets back a random character from a string stored in codeLetterCollector property
  getRandomElementFromString(): string {
    const codes: string = this.codeLetterCollector;
    let rand: number = this.getRandomNumber(codes.length);
    return codes.charAt(rand);
  }

  // Gets back a random element from an array stored in dow property
  getRandomElementFromArray(): string {
    const elements: string[] = this.dow;
    let rand: number = this.getRandomNumber(elements.length);
    return elements[rand];
  }

  // Gets a random number between 0 and the number is provided
  getRandomNumber(maxValue: number): number {
    return Math.floor(Math.random() * maxValue);
  }

  // Create a reservation string and store it in reservations field
  makeReservation(): void {
    let reservString: string = '';
    reservString += 'Booking# ';
    reservString += this.getDowBooking();
    reservString += ' for ';
    reservString += this.getCodeBooking();

    this.reservations.push(reservString);
  }
}

export { Reservation };