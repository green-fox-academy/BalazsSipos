'use strict';

const watchlist: string[] = [];

let securityAlcoholLoot: number = 0;

type FestivalGoer = {
  name: string,
  alcohol: number,
  guns: number
};

const queue: FestivalGoer[] = [
  { name: 'Amanda', alcohol: 10, guns: 1 },
  { name: 'Mark', alcohol: 0, guns: 0 },
  { name: 'Dolores', alcohol: 0, guns: 1 },
  { name: 'Wade', alcohol: 1, guns: 1 },
  { name: 'Anna', alcohol: 10, guns: 0 },
  { name: 'Rob', alcohol: 2, guns: 0 },
  { name: 'Joerg', alcohol: 20, guns: 0 }
];

// Queue of festivalgoers at entry
// no. of alcohol units
// no. of guns

// Create a securityCheck function that takes the queue as a parameter and returns a list of festivalgoers who can enter the festival

let i: number = 0;
let deleteElement: number[] = [];

function securityCheck(queueList): string[] {
  queueList.forEach(function (object) {
    if (object.alcohol > 0) {
      securityAlcoholLoot += object.alcohol;
      object.alcohol = 0;
    }
    if (object.guns > 0) {
      watchlist.push(object.name);
      deleteElement.push(i);
    }
    i++;
  });
  return queueList;
}

securityCheck(queue);
for (let i: number = deleteElement.length - 1; i >= 0; i--) {
  queue.splice(deleteElement[i], 1);
}

console.log('List of guys, who can enter: ');
console.log(queue);
console.log('Number of alcohols collected: ' + securityAlcoholLoot);
console.log(watchlist);

// If guns are found, remove them and put them on the watchlist (only the names)
// If alcohol is found confiscate it (set it to zero and add it to securityAlcholLoot) and let them enter the festival

// export = securityCheck;