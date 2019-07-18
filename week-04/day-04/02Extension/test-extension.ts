'use strict';

import { test } from 'tape';
import { add, maxOfThree, median, isVowel, translate } from './Extension';

test('add: 2 and 3 is 5', function (t: any): any {
  t.equal(add(2, 3), 5); // original
  t.equal(add(5, 3), 8);
  t.end();
});

test('add: 1 and 4 is 5', function (t: any): any {
  t.equal(add(1, 4), 5); // original
  t.equal(add(4, 4), 8);
  t.end();
});

test('max of three: first', function (t: any): any {
  t.equal(maxOfThree(5, 4, 3), 5); // original
  t.equal(maxOfThree(3, 1, 9), 9);
  t.end();
});

test('max of three: third', function (t: any): any {
  t.equal(maxOfThree(3, 4, 5), 5); // original
  t.equal(maxOfThree(-2, 4, 10), 10);
  t.equal(maxOfThree(3, 10, 10), 10);
  t.equal(maxOfThree(10, 10, 10), 10);
  t.equal(maxOfThree(10, 0, 10), 10);
  t.end();
});

test('median: four', function (t: any): any {
  t.equal(median([7, 5, 3, 5]), 5); // original
  t.equal(median([7, 5, 5, 5]), 5);
  t.equal(median([7, 5, 2, 2]), 3.5);
  t.equal(median([5, 5, 5, 5]), 5);
  t.equal(median([5, 5, 5, 5]), 5);
  t.equal(median([5, 1, 4, 5]), 4.5);
  t.equal(median([]), 0);
  t.equal(median([-2]), -2);
  t.end();
});

test('median: five', function (t: any): any {
  t.equal(median([1, 2, 3, 4, 5]), 3); // original
  t.equal(median([1, 2, 2, 4, 5]), 2);
  t.equal(median([10, 2, 2, 4, 5]), 4);
  t.end();
});

test('is vowel: a', function (t: any): any {
  t.ok(isVowel('a'));
  t.true(isVowel('A'));
  t.false(isVowel('f'));
  t.end();
});

test('is vowel: u', function (t: any): any {
  t.ok(isVowel('u'));
  t.end();
});

test('is vowel: k', function(t: any): any {
  t.notOk(isVowel('k'));
  t.end();
});

test('translate: bemutatkozik', function (t: any): any {
  t.equal(translate('bemutatkozik'), 'bevemuvutavatkovozivik'); // original
  t.equal(translate('trz'), 'trz');
  t.equal(translate('123'), '123');
  t.end();
});

test('translate: lagopus', function (t: any): any {
  t.equal(translate('lagopus'), 'lavagovopuvus');
  t.end();
});
