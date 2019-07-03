'use strict';

const canvas = document.querySelector('.main-canvas') as HTMLCanvasElement;
const ctx = canvas.getContext('2d') as CanvasRenderingContext2D;

// DO NOT TOUCH THE CODE ABOVE THIS LINE

// Fill the canvas with a checkerboard pattern.
function drawSquare(positionX: number, positionY: number, size: number) {
  ctx.fillRect(positionX, positionY, size, size);
}

let startingSize: number = 40;
let startingPositionX: number = (canvas.width - startingSize * 8) / 2;
let startingPositionY: number = (canvas.height - startingSize * 8) / 2;

for (let i: number = 0; i < 8; i++) {
  for (let j: number = 0; j < 8; j++) {
    if ((i % 2 === 1 && j % 2 === 1) || (i % 2 === 0 && j % 2 === 0)) {
      drawSquare(i * startingSize + startingPositionX, j * startingSize + startingPositionY, startingSize);
    }
  }
}

ctx.strokeRect(startingPositionX, startingPositionY, startingSize * 8, startingSize * 8);