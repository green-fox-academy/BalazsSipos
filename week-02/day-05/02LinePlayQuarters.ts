'use strict';

const canvas = document.querySelector('.main-canvas') as HTMLCanvasElement;
const ctx = canvas.getContext('2d') as CanvasRenderingContext2D;


let cropAmount: number = 0.2; // the percentage, we want to skip at top left and bottom right (0.2 = 20%)
let numberOfLines: number = 14;
let divideCanvas: number = 4;
let currentCanvasWidth: number = canvas.width / (divideCanvas / 2);
let currentCanvasHeight: number = canvas.height / (divideCanvas / 2);
let xStep = currentCanvasWidth * (1 - cropAmount) / numberOfLines; // the distance of x coordinates between to lines in px
let yStep = currentCanvasHeight * (1 - cropAmount) / numberOfLines;

// Draws the bottom left parts
function drawLines1(color: string, xStart: number, yStart: number) {
  ctx.strokeStyle = color;
  for (let i: number = 1; i <= numberOfLines; i++) {
    ctx.beginPath();
    ctx.moveTo(xStart, yStart + currentCanvasHeight * cropAmount + (i - 1) * yStep);
    ctx.lineTo(xStart + xStep * i, yStart + currentCanvasHeight);
    ctx.stroke();
  }
}

// Draws the upper right parts
function drawLines2(color: string, xStart: number, yStart: number) {
  ctx.strokeStyle = color;
  for (let i: number = 1; i <= numberOfLines; i++) {
    ctx.beginPath();
    ctx.moveTo(xStart + currentCanvasWidth * cropAmount + (i - 1) * xStep, yStart);
    ctx.lineTo(xStart + currentCanvasWidth, yStart + yStep * i);
    ctx.stroke();
  }
}

for (let i: number = 0; i < divideCanvas; i++) {
  for (let j: number = 0; j < divideCanvas; j++) {
    drawLines1('green', i * currentCanvasWidth, j * currentCanvasHeight);
  }
}
for (let i: number = 0; i < divideCanvas; i++) {
  for (let j: number = 0; j < divideCanvas; j++) {
    drawLines2('purple', i * currentCanvasWidth, j * currentCanvasHeight);
  }
}