import { Thing } from './thing';
import { Fleet } from './fleet';

let fleet = new Fleet();

// ORIGINAL DESCRIPTION
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

  // builds the below Fleet object
  // 1. [ ] Get milk
  // 2. [ ] Remove the obstacles
  // 3. [x] Stand up
  // 4. [x] Eat lunch
  main(): void {
    this.fleet.add(new Thing('Get milk'));
    this.fleet.add(new Thing('Remove the obstacles'));
    this.fleet.add(new Thing('Stand up'));
    this.fleet.getThings()[2].complete();
    this.fleet.add(new Thing('Eat lunch'));
    this.fleet.getThings()[3].complete();
  }

  // Prints the Fleet object
  print(): string {
    let fleet: Fleet = this.get();
    let things: Thing[] = fleet.getThings();
    let stringCollector: string = '';

    for (let i: number = 0; i < things.length; i++) {
      stringCollector += (i + 1) + '. [';
      stringCollector += things[i].getCompleted() ? 'x' : ' '; // ternary operator
      stringCollector += '] ' + things[i].getName();
      stringCollector += things.length - 1 !== i ? '\n' : ''; // ternary operator
    }
    return stringCollector;
  }

  get(): Fleet {
    return this.fleet;
  }
}

let fOT: FleetOfThings = new FleetOfThings(fleet);

// build the 4 Thing objects inside the Fleet object of the FleetOfThings object
fOT.main();

// print out the Fleet object
console.log(fOT.print());