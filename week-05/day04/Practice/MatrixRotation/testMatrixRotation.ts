'use strict';

import { Apple } from './Apple';
import { test } from 'tape';
const apple: Apple = new Apple();

test('check getApple\'s result', t => {
  const apple = new Apple();
  const actual = apple.getApple();
  const expected = 'apple';

  t.equal(actual, expected);
  t.end();
});