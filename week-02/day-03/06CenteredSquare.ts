'use strict';

const canvas = document.querySelector('.main-canvas') as HTMLCanvasElement;
const ctx = canvas.getContext('2d') as CanvasRenderingContext2D;

// DO NOT TOUCH THE CODE ABOVE THIS LINE

// Draw a green 10x10 square to the center of the canvas.
let x: number = 10;
ctx.fillStyle = 'green';
ctx.fillRect(ctx.canvas.width / 2 - x / 2, ctx.canvas.height / 2 - x / 2, x, x);
// ctx.beginPath();
// ctx.moveTo(ctx.canvas.width/2-10/2,ctx.canvas.height/2-10/2);
