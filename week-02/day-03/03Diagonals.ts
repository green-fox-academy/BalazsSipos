'use strict';

const canvas = document.querySelector('.main-canvas') as HTMLCanvasElement;
const ctx = canvas.getContext('2d') as CanvasRenderingContext2D;

// DO NOT TOUCH THE CODE ABOVE THIS LINE

// Draw the canvas' diagonals.
// If it starts from the upper-left corner it should be green, otherwise it should be red.
let x: number = 0;

ctx.beginPath();
ctx.moveTo(x, 0);
ctx.strokeStyle = x === 0 ? 'green' : 'red';
ctx.lineTo(canvas.width, canvas.height);
ctx.stroke();

x = canvas.width;

ctx.beginPath();
ctx.moveTo(x, 0);
ctx.strokeStyle = x === 0 ? 'green' : 'red';
ctx.lineTo(0, canvas.height);
ctx.stroke();