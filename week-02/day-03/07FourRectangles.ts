'use strict';

const canvas = document.querySelector('.main-canvas') as HTMLCanvasElement;
const ctx = canvas.getContext('2d') as CanvasRenderingContext2D;

// DO NOT TOUCH THE CODE ABOVE THIS LINE

// Draw four different size and color rectangles.
// Avoid code duplication.
function drawRectangle(x: number, y: number, a: number, b: number, color: string) {
  ctx.fillStyle = color;
  ctx.fillRect(x, y, a, b);
}

drawRectangle(10, 10, 50, 100, 'red');
drawRectangle(300, 10, 100, 50, 'green');
drawRectangle(500, 200, 50, 50, 'blue');
drawRectangle(40, 300, 500, 10, 'purple');