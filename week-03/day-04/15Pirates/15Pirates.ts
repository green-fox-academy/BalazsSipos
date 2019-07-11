'use strict';

// Pirates
// Create a Pirate class. While you can add other fields and methods, you must have these methods:-

// drinkSomeRum() -    the Pirate some
// howsItGoingMate() - when called, the Pirate replies, if drinkSomeRun was called:-
// 0 to 4 times, "Pour me anudder!"
// else, "Arghh, I'ma Pirate. How d'ya d'ink its goin?", the pirate passes out and sleeps it off.
// If you manage to get this far, then you can try to do the following. - die() - this kills off the pirate, in which case, DrinkSomeRum, etc. just result in he's dead. - brawl(x) - where pirate fights another pirate (if that other pirate is alive) and there's a 1/3 chance, 1 dies, the other dies or they both pass out.

// And... if you get that far...

// Add a parrot.

class Pirate {
  rumNumber: number = 0;
  state: string = 'alive';

  // Adds to rumNumber a random number between 1 and 5
  drinkSomeRum(): void {
    if (this.state !== 'died') {
      this.rumNumber += Math.ceil(Math.random() * 5);
    }
  }

  howsItGoingMate(): void {
    if (this.state !== 'died') {
      if (this.rumNumber <= 4) {
        console.log('Pour me anudder!');
      } else {
        console.log('Arghh, I\'ma Pirate. How d\'ya d\'ink its goin?');
        this.sleep();
      }
    } else {
      console.log('He is dead.');
    }
  }

  // Kills the pirate
  die(): void {
    if (this.state !== 'died') {
      this.state = 'died';
    }
  }

  // Sleeps the pirate
  sleep(): void {
    if (this.state !== 'died') {
      this.state = 'sleeping';
    }
  }

  // Fight, after that 1/3 chance pirate1 will die, 1/3 pirate2 dies, 1/3 change both sleeps out
  brawl(otherPir: Pirate): void {
    if (this.state !== 'died' && otherPir.state !== 'died') {
      let chance: number = Math.ceil(Math.random() * 3); // a number between 1 and 3
      if (chance === 1) {
        this.die();
      } else if (chance === 2) {
        otherPir.die();
      } else if (chance === 3) {
        this.sleep();
        otherPir.sleep();
      }
    }
  }
}

let pir1 = new Pirate();
console.log(pir1);

// pir1.drinkSomeRum();
// pir1.drinkSomeRum();
// pir1.drinkSomeRum();
// console.log(pir1);

// pir1.howsItGoingMate();
// console.log(pir1);

// pir1.die();
// console.log(pir1);

// let pir2 = new Pirate();
// console.log(pir2);

// console.log('---------------------------------');
// pir1.brawl(pir2);
// console.log(pir1);
// console.log(pir2);
// pir1.brawl(pir2);
// console.log(pir1);
// console.log(pir2);
// pir1.brawl(pir2);
// console.log(pir1);
// console.log(pir2);
// pir1.brawl(pir2);
// console.log(pir1);
// console.log(pir2);
// pir1.brawl(pir2);
// console.log(pir1);
// console.log(pir2);
