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

test('check sum function', t => {
  const apple = new Apple();
  t.equal(apple.sum([]), 0);
  t.equal(apple.sum([10]), 10);
  t.equal(apple.sum([1,2]), 3);
  t.end();
});

test('check palindrom', t => {
  t.true(apple.palindromChecker('abc', 'cba'));
  t.false(apple.palindromChecker('abc', 'cbsa'));
  t.end();
});

test('number of letter', t => {
  t.deepEqual(apple.charDictionary('caaabcc'), {'a': 3, 'b': 1, 'c': 3});
  t.end();
});

test('test fibonacci', t => {
  t.equal(apple.fibonacci(1), 0);
  t.equal(apple.fibonacci(2), 1);
  t.equal(apple.fibonacci(3), 1);
  t.equal(apple.fibonacci(4), 2);
  t.equal(apple.fibonacci(5), 3);
  t.equal(apple.fibonacci(6), 5);
  t.end();
});