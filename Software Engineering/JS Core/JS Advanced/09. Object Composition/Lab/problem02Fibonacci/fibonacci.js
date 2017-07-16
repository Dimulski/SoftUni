function getFib() {
    let previous = 1; // for starting purposes
    let current = 0;
    return function () {
        let newFib = previous + current;
        previous = current;
        current = newFib;
        return newFib;
    };
}

let fib = getFib();
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());
console.log(fib());