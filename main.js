// list-like objects...
// they are a single object that contains multiple values stored in a list

let shopping = ['bread', 'milk', 'cheese', 'hummus', 'crackers', 'carrots'];
console.log(shopping);

// Data can be stored at non-contiguois locations in the array
let sparse = ['1', , '123'];

// store multiple data types
let random = [123, 'tree', {}, function () {
    console.log('inside an array');
}, 'last element'];
console.log(random);
console.log(random[3]());
console.log('Length of random array:', random.length)
console.log('Last element of random array:', random[random.length - 1]);

// loop over an array
// loops through a block of code a number of times
console.log('shopping', shopping);
console.log('shopping', shopping.length);
// for ( ; ; )
for (var i = 0; i < shopping.length; i++) {
    console.log('shopping item', shopping[i]);
}

// for/of
// loops through the values of an object
for (item of shopping) {
    console.log('shopping item of:', item);
}

// for/in
// loops through the properties of an object
for (item in shopping) {
    console.log('shopping item in:', item);
}

// loop over an array
// Array.prototype.forEach()
// method executes a provided function once for each array element
shopping.forEach(function (item, index, array) {
    console.log(item, index);
})

shopping.forEach(function (item) {
    console.log('item:', item);
})

// actors
let actors = [{ firstName: 'Kyle' }];
actors.forEach(function (actor) {
    console.log(actor.firstName);
});

// multidimensional
let multidimensional = [['bread', 'milk'], ['couch', 'chair']];

// Array.propotype.concat
let together = shopping.concat(random, actors);
let together1 = random.concat(shopping);
console.log('together:', together);

// 
console.log(shopping);
console.log(shopping.reverse());
console.log(shopping);
console.log(shopping.sort());

// Arrow Function expression
// compact alternative to a regular function expression
shopping.forEach(function (item, index, array) {
    console.log(item, index);
})
shopping.forEach((item, index) => { console.log('arrow:', item, ', index:', index) })

// find an item in our array
// returns the value of the first element in the provided array...
console.log('find:', actors.find(actor => actor.firstName === 'Kyle'));





