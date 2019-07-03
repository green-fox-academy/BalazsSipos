'use strict';

const canvas = document.querySelector('.main-canvas') as HTMLCanvasElement;
const ctx = canvas.getContext('2d') as CanvasRenderingContext2D;

// DO NOT TOUCH THE CODE ABOVE THIS LINE

// Draw the night sky:
//  - The background should be black
//  - The stars should be small squares
//  - The stars should have random positions on the canvas
//  - The stars should have random color (some shade of grey)

let greyRGBs: string[] = ['rgb(220,220,220)', 'rgb(211,211,211)', 'rgb(192,192,192)', 'rgb(169,169,169)', 'rgb(128,128,128)', 'rgb(105,105,105)', 'rgb(112,128,144)'];
let starSizeMax: number = 20;
let numberOfStars: number = 60;

//backgroung
ctx.fillStyle = 'black';
ctx.fillRect(0, 0, canvas.width, canvas.height);

function drawStar(positionX: number, positionY: number, size: number) {
  ctx.fillStyle = greyRGBs[Math.floor(Math.random() * 7)];
  ctx.fillRect(positionX, positionY, size, size);
}

for (let i: number = 1; i <= numberOfStars; i++) {
  drawStar(Math.floor(Math.random() * (canvas.width - starSizeMax)), Math.floor(Math.random() * (canvas.height - starSizeMax)), Math.floor(Math.random() * starSizeMax));
}
