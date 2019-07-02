'use strict';

let isbn = {
  '978-1-60309-452-8': 'A Letter to Jo',
  '978-1-60309-459-7': 'Lupus',
  '978-1-60309-444-3': 'Red Panda and Moon Bear',
  '978-1-60309-461-0': 'The Lab'
}

// Print all the key-value pairs in the following format
Object.keys(isbn).forEach(function (value) {
  console.log(isbn[value] + ' (ISBN: ' + value + ')');
});

// Remove the key-value pair with key 978-1-60309-444-3
delete isbn['978-1-60309-444-3'];

// Remove the key-value pair with value The Lab
Object.keys(isbn).forEach(function (key) {
  if (isbn[key] === 'The Lab') {
    delete isbn[key];
  }
});

// Add the following key-value pairs to the map
isbn['978-1-60309-450-4'] = 'They Called Us Enemy';
isbn['978-1-60309-453-5'] = 'Why Did We Trust Him?';

// Print whether there is an associated value with key 478-0-61159-424-8 or not
if (isbn['478-0-61159-424-8']) {
  console.log('There is an associated value with key 478-0-61159-424-8');
} else {
  console.log('There is not any associated value with key 478-0-61159-424-8');
}

// Print the value associated with key 978-1-60309-453-5
console.log('Value of key 978-1-60309-453-5: ' + isbn['978-1-60309-453-5']);