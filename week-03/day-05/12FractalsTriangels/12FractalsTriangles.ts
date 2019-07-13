'use strict';

const canvas = document.querySelector('.main-canvas') as HTMLCanvasElement;
const ctx = canvas.getContext('2d') as CanvasRenderingContext2D;

let deepLevel: number = 7;

function drawTriangle(A: number[], B: number[], C: number[], num: number) {
  if (num >= 1) {
    // Draw the 3 sides of the triangle
    ctx.beginPath();
    ctx.moveTo(A[0], A[1]);
    ctx.lineTo(B[0], B[1]);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(B[0], B[1]);
    ctx.lineTo(C[0], C[1]);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(C[0], C[1]);
    ctx.lineTo(A[0], A[1]);
    ctx.stroke();

    // Identify the halfway points of all 3 sides
    let newA: number[] = makeHalfPoint(A, B);
    let newB: number[] = makeHalfPoint(B, C);
    let newC: number[] = makeHalfPoint(C, A);

    drawTriangle(A, newA, newC, num - 1);
    drawTriangle(B, newB, newA, num - 1);
    drawTriangle(C, newB, newC, num - 1);
  }
}

// Gives back the half point between two points
function makeHalfPoint(A: number[], B: number[]): number[] {
  let x: number = (A[0] + B[0]) / 2;
  let y: number = (A[1] + B[1]) / 2;
  return [x, y];
}

drawTriangle([0, 0], [canvas.width, 0], [canvas.width / 2, canvas.height], deepLevel);