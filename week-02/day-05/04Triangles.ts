'use strict';

const canvas = document.querySelector('.main-canvas') as HTMLCanvasElement;
const ctx = canvas.getContext('2d') as CanvasRenderingContext2D;

let numberOfLines: number = 21;
let triangleSizeLength: number = 800;
let xStep = triangleSizeLength / 2 / numberOfLines; // the distance of x coordinates between the lines in px
let triangleM = ((triangleSizeLength) ** 2 - (triangleSizeLength / 2) ** 2) ** 0.5; // the height of the triangle
let yStep = triangleM / numberOfLines; // the distance of y coordinates between the lines in px

function drawLinesRight() {
  for (let i: number = 1; i <= numberOfLines; i++) {
    ctx.beginPath();
    ctx.moveTo(triangleSizeLength / 2 + (i - 1) * xStep, 0 + (i - 1) * yStep);
    ctx.lineTo((i - 1) * triangleSizeLength / numberOfLines, triangleM);
    ctx.stroke();
  }
}

function drawLinesLeft() {
  for (let i: number = 1; i <= numberOfLines; i++) {
    ctx.beginPath();
    ctx.moveTo(xStep * i, triangleM - (triangleM / numberOfLines) * i);
    ctx.lineTo(triangleSizeLength / numberOfLines * i, triangleM);
    ctx.stroke();
  }
}

function drawLinesHorizontal() {
  for (let i: number = 1; i <= numberOfLines; i++) {
    ctx.beginPath();
    ctx.moveTo(triangleSizeLength / 2 - xStep * i, yStep * i);
    ctx.lineTo(triangleSizeLength / 2 + xStep * i, yStep * i);
    ctx.stroke();
  }
}

drawLinesRight();
drawLinesLeft();
drawLinesHorizontal();