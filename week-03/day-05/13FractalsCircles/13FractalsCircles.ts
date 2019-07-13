'use strict';

const canvas = document.querySelector('.main-canvas') as HTMLCanvasElement;
const ctx = canvas.getContext('2d') as CanvasRenderingContext2D;

let deepLevel: number = 5;

function drawCircle(x: number, y: number, r: number, num: number) {
  if (num >= 1) {
    // Draw the circle
    ctx.beginPath();
    ctx.arc(x, y, r, 0, Math.PI * 2);
    ctx.stroke();

    // Identify the center of all 3 circles
    let centerPoints: number[][] = giveCentrePoints([x, y], r);
    drawCircle(centerPoints[0][0], centerPoints[0][1], r / 2, num - 1);
    drawCircle(centerPoints[1][0], centerPoints[1][1], r / 2, num - 1);
    drawCircle(centerPoints[2][0], centerPoints[2][1], r / 2, num - 1);
  }
}

// Gives back the 3 centrepoint based on the big circle
function giveCentrePoints(C: number[], r: number): number[][] {
  let xDistance: number = Math.cos(Math.PI / 6);
  let cir1: number[] = [C[0] - xDistance * r / 2, C[1] + 0.25 * r];
  let cir2: number[] = [C[0] + xDistance * r / 2, C[1] + 0.25 * r];
  let cir3: number[] = [C[0], C[1] - 0.5 * r];
  return [cir1, cir2, cir3];
}

// drawTriangle([0, 0], [canvas.width, 0], [canvas.width / 2, canvas.height], deepLevel);
drawCircle(canvas.width / 2, canvas.height / 2, canvas.width / 2, deepLevel);