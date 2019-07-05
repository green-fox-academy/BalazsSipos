'use strict';

const canvas = document.querySelector('.main-canvas') as HTMLCanvasElement;
const ctx = canvas.getContext('2d') as CanvasRenderingContext2D;

let drawlines = {
  numberOfHexagonPerSize: 4,
  widthInTriangles: 0,
  xStep: 0, // the distance of x coordinates between the lines in px
  yStep: 0, // the distance of y coordinates between the lines in px
  startXY: [];

  // build up the initial values of the properties
  initialize: function () {
    this.widthInTriangles = (this.numberOfHexagonPerSize - 1) * 3 + 2;
    this.xStep = canvas.width / this.widthInTriangles;
    this.yStep = ((this.xStep) ** 2 - (this.xStep / 2) ** 2) ** 0.5;
    this.moveDownRight = [this.xStep * 1.5, this.yStep];
    this.moveUpRight = [this.xStep * 1.5, this.yStep * (-1)];
    this.startXY = [((this.numberOfHexagonPerSize - 2) * 1.5 + 2) * this.xStep, 0];
  },

  // Draw a single line based on start and end point
  drawLine: function (startXY: number[], endXY: number[]): void {
    ctx.beginPath();
    ctx.moveTo(startXY[0], startXY[1]);
    ctx.lineTo(endXY[0], endXY[1]);
    ctx.stroke();
  },

  // Draw one hexagon with 6 lines
  drawHexagon: function (startXY: number[]): void {
    let pointA: number[] = [startXY[0] + this.xStep, startXY[1]];
    let pointB: number[] = [startXY[0] + this.xStep * 1.5, startXY[1] + this.yStep];
    let pointC: number[] = [startXY[0] + this.xStep, startXY[1] + this.yStep * 2];
    let pointD: number[] = [startXY[0], startXY[1] + this.yStep * 2];
    let pointE: number[] = [startXY[0] - this.xStep * 0.5, startXY[1] + this.yStep];
    this.drawLine(startXY, pointA); // -
    this.drawLine(pointA, pointB); // \
    this.drawLine(pointB, pointC); // /
    this.drawLine(pointC, pointD); // -
    this.drawLine(pointD, pointE); // \
    this.drawLine(pointE, startXY); // /
  },

  // Draw a vertical set of hexagons
  paintDown(startXY: number[], PiecestoPaint: number) {
    for (let i: number = 1; i <= PiecestoPaint; i++) {
      this.drawHexagon([startXY[0], startXY[1] + (i - 1) * 2 * this.yStep]);
    }
  },

  // Draw all hexagons
  drawAllHexagons: function () {
    this.paintDown(this.startXY, this.numberOfHexagonPerSize * 2 - 1);
    for (let i: number = 1; i < this.numberOfHexagonPerSize; i++) {
      this.paintDown([this.startXY[0] - 1.5 * i * this.xStep, this.startXY[1] + this.yStep * i], this.numberOfHexagonPerSize * 2 - 1 - i);
      this.paintDown([this.startXY[0] + 1.5 * i * this.xStep, this.startXY[1] + this.yStep * i], this.numberOfHexagonPerSize * 2 - 1 - i);
    }
  }

}

drawlines.initialize();
drawlines.drawAllHexagons();