'use strict';

let lineCount: number = 7;
let width: number = lineCount  * 2 - 1;
let middle: number = ( lineCount + 1 ) / 2;

// Write a program that draws a
// diamond like this:
//
//    *
//   ***
//  *****
// *******
//  *****
//   ***
//    *
//
// The diamond should have as many lines as lineCount is
for ( let i:number = 1;i<=lineCount;i++ ) {
    let collector:string = '';
    for ( let j: number = 1;j<=lineCount;j++ ) {
        if ( i <= middle ) {
            if ( j > middle - i && j < middle +i ) { 
                collector += '*';
            } else {
                collector += ' ';
            }
        }
        if ( i > middle ) {
            if ( j > i - middle && j < lineCount + middle - i +1 ) {
                collector += '*';
            } else {
                collector += ' ';
            }
        }
        //console.log(j);
    }
    console.log(collector);
}