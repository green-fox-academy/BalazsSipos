'use strict';

const canvas = document.querySelector('.main-canvas') as HTMLCanvasElement;
const ctx = canvas.getContext('2d') as CanvasRenderingContext2D;

// DO NOT TOUCH THE CODE ABOVE THIS LINE

// Create a square drawing function that takes 2 parameters:
// The square size, and the fill color,
// and draws a square of that size and color to the center of the canvas.
// Create a loop that fills the canvas with a rainbow of colored squares.

function drawRainboxSquares(x: number, color: string) {
  ctx.fillStyle = color;
  ctx.fillRect(canvas.width / 2 - x / 2, canvas.height / 2 - x / 2, x, x);
}

let rainbowColors = ['red', 'orange', 'yellow', 'green', 'blue', 'purple'];
let i: number = 0;

rainbowColors.forEach(function (value) {
  drawRainboxSquares(400 - 70 * i, value);
  i++;
});

