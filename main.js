let shopping = ['bread', 'milk', 'cheese', 'hummus'];
//  this is an array
console.log(shopping);

let spars = ['1', , '123'];
let random = [123, 'tree', {}];

console.log(random.length);

// loop over an array
for (var i = 0; i < shopping.length; i++) {
    console.log('shopping');
}

// loop over an array
// loops through properties
// Array.prototype.forEach

shopping.forEach(function (item, index, array) {
    console.log(item, index);
}

// Arrow function expression
// compact alternative to a regular function expression
shopping.forEach(function (item, index, array) {
    console.log(item, index, array)
)}
    shopping.forEach((item, index, array)) => console.log('other stuff')

// find an item
// return value of first item in array that matches
shopping.find(item => item === bread)
console.log('find')









