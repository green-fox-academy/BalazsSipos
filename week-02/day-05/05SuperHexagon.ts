'use strict';

const canvas = document.querySelector('.main-canvas') as HTMLCanvasElement;
const ctx = canvas.getContext('2d') as CanvasRenderingContext2D;

let drawlines = {
  numberOfHexagonPerSize: 4,
  widthInTriangles: 0,
  // triangleSizeLength: 0,
  xStep: 0, // the distance of x coordinates between the lines in px
  // triangleM: ((this.triangleSizeLength) ** 2 - (this.triangleSizeLength / 2) ** 2) ** 0.5, // the height of the triangle
  yStep: 0, // the distance of y coordinates between the lines in px
  moveDownRight: [],
  moveUpRight: [],
  moveDown: [],

  initialize: function () {
    this.widthInTriangles = (this.numberOfHexagonPerSize - 1) * 3 + 2;
    // this.triangleSizeLength = canvas.width / this.widthInTriangles;
    this.xStep = canvas.width / this.widthInTriangles;
    this.yStep = ((this.xStep) ** 2 - (this.xStep / 2) ** 2) ** 0.5;
    this.moveDownRight = [this.xStep * 1.5, this.yStep];
    this.moveUpRight = [this.xStep * 1.5, this.yStep * (-1)];
  },

  drawLinesRight: function (repetition: number, startXY: number[], moveType: number[]) {
    let xStep: number = this.xStep;
    let yStep: number = this.yStep;
    for (let i: number = 1; i <= repetition; i++) {
      ctx.beginPath();
      ctx.moveTo(startXY[0] + (i - 1) * moveType[0], startXY[1] + (i - 1) * moveType[1]);
      ctx.lineTo((startXY[0] + xStep / 2) + (i - 1) * moveType[0], (startXY[1] - yStep) + (i - 1) * moveType[1]);
      ctx.stroke();
    }
  }
}

// for (let i: number = 1; i <= numberOfHexagonPerSize * 2 - 1; i++) {
//   drawLinesRight(numberOfHexagonPerSize * 2, [0, 4 * yStep]);
// }
// drawlines.drawLinesRight(drawlines['numberOfHexagonPerSize'] * 2, [0, 4 * drawlines['yStep']);

drawlines.initialize();


// Right angles
drawlines.drawLinesRight(drawlines['numberOfHexagonPerSize'] * 2, [0, drawlines['numberOfHexagonPerSize'] * drawlines['yStep']], drawlines['moveDownRight']);

for (let i: number = 1; i <= (drawlines['numberOfHexagonPerSize'] - 1); i++) {
  drawlines.drawLinesRight(drawlines['numberOfHexagonPerSize'] * 2 - i, [0, (drawlines['numberOfHexagonPerSize'] + i * 2) * drawlines['yStep']], drawlines['moveDownRight']);
}
for (let i: number = 1; i <= (drawlines['numberOfHexagonPerSize'] - 1); i++) {
  drawlines.drawLinesRight(drawlines['numberOfHexagonPerSize'] * 2 - i, [drawlines['xStep'] * 1.5 * i, (drawlines['numberOfHexagonPerSize'] - i) * drawlines['yStep']], drawlines['moveDownRight']);
}

// Left angles
drawlines.drawLinesRight(drawlines['numberOfHexagonPerSize'] * 2, [0, (drawlines['numberOfHexagonPerSize']*2+2) * drawlines['yStep']], drawlines['moveUpRight']);


// document.write(drawlines['numberOfHexagonPerSize']);
// document.write(drawlines.widthInTriangles);
// document.write(drawlines.xStep);
// document.write(drawlines.yStep);