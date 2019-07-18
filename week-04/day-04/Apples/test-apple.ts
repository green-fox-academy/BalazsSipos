'use strict';

import { Apple } from './Apple';
import { test } from 'tape';

test('check getApple\'s result', t => {
  const apple = new Apple();
  const actual = apple.getApple();
  const expected = 'apple';

  t.equal(actual, expected);
  t.end();
});

test('check sum function', t => {
  const apple = new Apple();
  t.equal(apple.sum([]), 0);
  t.equal(apple.sum([10]), 10);
  t.equal(apple.sum([1,2]), 3);
  t.end();
});