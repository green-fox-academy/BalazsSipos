'use strict';

const canvas = document.querySelector('.main-canvas') as HTMLCanvasElement;
const ctx = canvas.getContext('2d') as CanvasRenderingContext2D;

// DO NOT TOUCH THE CODE ABOVE THIS LINE

// Reproduce this:
// [https://github.com/green-fox-academy/teaching-materials/blob/master/workshop/drawing/assets/r4.png]

ctx.fillStyle = 'purple';

function drawPurpleSquare(x: number, a: number) {
  ctx.fillRect(x, x, a, a);
}

let startingSize: number = 18;
let muliplier: number = 1.5;

let position: number = 0;
let size: number = startingSize;

for (let i: number = 0; i < 6; i++) {
  drawPurpleSquare(0 + position, size);
  position += startingSize * muliplier ** i;
  size *= muliplier;
  console.log(i + ': ' + position);
  console.log(i + ': ' + size);
}