'use strict';

const canvas = document.querySelector('.main-canvas') as HTMLCanvasElement;
const ctx = canvas.getContext('2d') as CanvasRenderingContext2D;

// DO NOT TOUCH THE CODE ABOVE THIS LINE

// Reproduce this:
// [https://github.com/green-fox-academy/teaching-materials/blob/master/workshop/drawing/assets/r3.png]

ctx.fillStyle = 'purple';

function drawPurpleSquare(x: number, a: number) {
  ctx.fillRect(x, x, a, a);
}

for (let i: number = 0; i < 19; i++) {
  drawPurpleSquare(0 + i * 20, 20);
}