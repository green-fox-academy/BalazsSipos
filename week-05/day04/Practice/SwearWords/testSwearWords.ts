'use strict';

import { filterOutSwearWorld} from './swearWords';
import { iterateSwearWords} from './swearWords';
import { readContent} from './swearWords';
import { test } from 'tape';

test('file opening', (t: any) => {

  t.equals(readContent('input2.txt'), 'abcFuckabc abcfuckdef def bloody edf\r\nfuck\r\ntrdshits\r\nfucker fgrcunt');
  t.equals(readContent('wrongfilename'), undefined);
  t.end();
});

test('check normal filtering functionality', (t: any) => {

  t.equals(filterOutSwearWorld('asdf test dsf testa', 'test'), 'asdf  dsf a');
  t.equals(iterateSwearWords('input2.txt'), 7);
  t.equals(iterateSwearWords('input3.txt'), undefined);
  t.end();
});