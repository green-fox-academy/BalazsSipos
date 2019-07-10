import { Thing } from './thing';
import { Fleet } from './fleet';
import { Thing } from './thing';

let fleet = new Fleet();

// -  You have the `Thing` class
// -  You have the `Fleet` class
// -  Create the `FleetOfThings` class with a `main` method
// -  Download those, use those
// -  In the `main` method create a fleet
// -  Achieve this output:
//  Crete a fleet of things to have this output:

class FleetOfThings {
  private fleet: Fleet;

  constructor(fleet: Fleet) {
    this.fleet = fleet;
  }

  main(): void {
    let thing1: Thing = new Thing('Get milk');
    let thing2: Thing = new Thing('Remove the obstacles')');
    let thing3: Thing = new Thing('Stand up');
    thing3.complete();
    let thing4: Thing = new Thing('Eat lunch');
    thing4.complete();

    let things: Thing[] = [];
    
  }

  get(): Fleet {
    return this.fleet;
  }
}

let fOT: FleetOfThings = new FleetOfThings(fleet);

// Initial state of fOT
console.log(fOT);

let things: Thing[] = [];


things.push(new Thing('Get milk'));
things.push(new Thing('Remove the obstacles'));
things.push(new Thing('Stand up'));
things.push(new Thing('Stand up'));
things.push(new Thing('Eat lunch'));

fOT.main(things);
let sg: Fleet = fOT.get();
console.log(sg);
console.log(fOT);

// 1. [ ] Get milk
// 2. [ ] Remove the obstacles
// 3. [x] Stand up
// 4. [x] Eat lunch

// Hint: You have to create a `print()` method as well