'use strict';

// Create a PostIt a class that has
// a backgroundColor
// a text on it
// a textColor
class PostIt {
  backgroundColor: string;
  text: string;
  textColor: string;

  constructor(bckG: string, txt: string, txtC: string) {
    this.backgroundColor = bckG;
    this.text = txt;
    this.textColor = txtC;
  }
}

// Create a few example post-it objects:
// an orange with blue text: "Idea 1"
let postIt_1: PostIt = new PostIt('orange', 'Idea 1', 'blue');
// a pink with black text: "Awesome"
let postIt_2: PostIt = new PostIt('pink', 'Awesome', 'black');

// a yellow with green text: "Superb!"
let postIt_3: PostIt = new PostIt('yellow', 'Superb!', 'green');

console.log(postIt_1);
console.log(postIt_2);
console.log(postIt_3);