'use strict';

import { filterOutSwearWorld} from './swearWords';
import { iterateSwearWords} from './swearWords';
import { readContent} from './swearWords';
import { test } from 'tape';

test('file opening', (t: any) => {

  t.equals(readContent('input2.txt'), 'testtesttest');
  t.equals(readContent('wrongfilename'), undefined);
  t.end();
});

test('check normal rotate functionality', (t: any) => {

  t.deepEqual(rotateMatrix([[1,2,3],[4,5,6],[7,8,9]]), [[7,4,1],[8,5,2],[9,6,3]]);
  t.deepEqual(rotateMatrix([[1,2,3,4],[5,6,7,8],[1,3,5,7],[2,4,6,8]]), [[2,1,5,1],[4,3,6,2],[6,5,7,3],[8,7,8,4]]);
  t.end();
});