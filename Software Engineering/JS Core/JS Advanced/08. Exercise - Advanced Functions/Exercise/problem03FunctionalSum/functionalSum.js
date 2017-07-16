let f = (function () {
    let sum = 0;
    return function add(number) {
        sum += number;
        add.toString = function () {
            return sum;
        };

        return add;
    }
})();

console.log(f(5).toString());
console.log(f(5).toString());