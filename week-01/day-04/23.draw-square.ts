'use strict';

let lineCount: number = 10;
let width: number = lineCount  * 2 - 1;
let middle: number = ( lineCount + 1 ) / 2;

// Write a program that draws a square like this:
//
// %%%%%%
// %    %
// %    %
// %    %
// %    %
// %%%%%%
//
// The square should have as many lines as lineCount is
for ( let i:number = 1;i<=lineCount;i++ ){
    let collector:string = '';
    for ( let j: number = 1;j<=lineCount;j++ ){
        if ( ( i == 1 || i == lineCount ) || ( j == 1 || j == lineCount ) ) {
            collector += '%';
        } else {
            collector += ' ';
        }
    }
    console.log(collector);
}