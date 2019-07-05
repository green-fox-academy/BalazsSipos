'use strict';

const canvas = document.querySelector('.main-canvas') as HTMLCanvasElement;
const ctx = canvas.getContext('2d') as CanvasRenderingContext2D;

let cropAmount: number = 0.2; // the percentage, we want to skip at top left and bottom right (0.2 = 20%)
let numberOfLines: number = 14;
let xStep = canvas.width * (1 - cropAmount) / numberOfLines; // the distance of x coordinates between to lines in px
let yStep = canvas.height * (1 - cropAmount) / numberOfLines;

function drawLines1(color: string, xLength: number, yLength: number) {
  ctx.strokeStyle = color;
  for (let i: number = 1; i <= numberOfLines; i++) {
    ctx.beginPath();
    ctx.moveTo(0, yLength * cropAmount + (i - 1) * yStep);
    ctx.lineTo(xStep * i, yLength);
    ctx.stroke();
  }
}

function drawLines2(color: string, xLength: number, yLength: number) {
  ctx.strokeStyle = color;
  for (let i: number = 1; i <= numberOfLines; i++) {
    ctx.beginPath();
    ctx.moveTo(xLength*cropAmount + (i-1)*xStep, 0);
    ctx.lineTo(xLength, i*yStep);
    ctx.stroke();
  }
}

drawLines1('green', canvas.width, canvas.height);
drawLines2('purple', canvas.width, canvas.height);