'use strict';

const canvas = document.querySelector('.main-canvas') as HTMLCanvasElement;
const ctx = canvas.getContext('2d') as CanvasRenderingContext2D;

let numberOfLines: number = 14;
let xStep = canvas.width / 2 / numberOfLines; // the distance of x coordinates between to lines in px
let yStep = canvas.height / 2 / numberOfLines;

ctx.strokeStyle = 'green';
// Draws upper left part
function drawLinesUpperLeft() {
  for (let i: number = 1; i <= numberOfLines; i++) {
    ctx.beginPath();
    ctx.moveTo((i - 1) * xStep, canvas.height / 2);
    ctx.lineTo(canvas.width / 2, canvas.height / 2 - i * yStep);
    ctx.stroke();
  }
}

// Draws upper right part
function drawLinesUpperRight() {
  // ctx.strokeStyle = color;
  for (let i: number = 1; i <= numberOfLines; i++) {
    ctx.beginPath();
    ctx.moveTo(canvas.width / 2, (i - 1) * yStep);
    ctx.lineTo(canvas.width / 2 + i * xStep, canvas.height / 2);
    ctx.stroke();
  }
}

// Draws bottom left part
function drawLinesBottomLeft() {
  // ctx.strokeStyle = color;
  for (let i: number = 1; i <= numberOfLines; i++) {
    ctx.beginPath();
    ctx.moveTo((i - 1) * xStep, canvas.height / 2);
    ctx.lineTo(canvas.width / 2, canvas.height / 2 + i * yStep);
    ctx.stroke();
  }
}

// Draws bottom right part
function drawLinesBottomRight() {
  // ctx.strokeStyle = color;
  for (let i: number = 1; i <= numberOfLines; i++) {
    ctx.beginPath();
    ctx.moveTo(canvas.width / 2, canvas.height / 2 + i * yStep);
    ctx.lineTo(canvas.width - (i - 1) * xStep, canvas.height / 2);
    ctx.stroke();
  }
}
drawLinesUpperLeft('green');
drawLinesUpperRight('green');
drawLinesBottomLeft('green');
drawLinesBottomRight('green');