'use strict';

let phoneNumbers = {
  'William A. Lathan': '405-709-1865',
  'John K. Miller': '402-247-8568',
  'Hortensia E. Foster': '606-481-6467',
  'Amanda D. Newland': '319-243-5613',
  'Brooke P. Askew': '307-687-2982'
}

// What is John K. Miller's phone number?
console.log(phoneNumbers['John K. Miller']);

// Whose phone number is 307-687-2982?
Object.keys(phoneNumbers).forEach(function (key) {
  if (phoneNumbers[key] === '307-687-2982') {
    console.log(key);
  }
});

// Do we know Chris E. Myers' phone number?
if (phoneNumbers['Chris E. Myers']) {
  console.log('Phone number is :' + phoneNumbers['Chris E. Myers']);
} else {
  console.log('We do not know Chris E. Myers\' phone number.');
}

console.log(phoneNumbers);