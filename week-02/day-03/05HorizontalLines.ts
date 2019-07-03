
'use strict';

const canvas = document.querySelector('.main-canvas') as HTMLCanvasElement;
const ctx = canvas.getContext('2d') as CanvasRenderingContext2D;

// DO NOT TOUCH THE CODE ABOVE THIS LINE

// Create a function that draws a single line and takes 2 parameters:
// the x and y coordinates of the line's starting point
// and draws a 50 long horizontal line from that point.
// Draw at least 3 lines with that function using a loop.

function drawALine(x: number, y: number) {
  ctx.beginPath();
  ctx.moveTo(x, y);
  ctx.lineTo(x + 50, y);
  ctx.stroke();
}

drawALine(50, 50);
drawALine(200, 200);
drawALine(500, 150);
drawALine(500, 400);
drawALine(500, 10);