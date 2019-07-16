'use strict';

import { Reservation } from "./Reservation";

let reservation = new Reservation();

// Test the methods
console.log(reservation);

console.log(reservation.getCodeBooking());
console.log(reservation.getDowBooking());

reservation.makeReservation();
reservation.makeReservation();
reservation.makeReservation();
reservation.makeReservation();
reservation.makeReservation();
reservation.makeReservation();
reservation.makeReservation();
reservation.makeReservation();

console.log(reservation.reservations);