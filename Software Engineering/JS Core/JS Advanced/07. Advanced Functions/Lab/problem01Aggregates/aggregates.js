function callAggregates(arr) {
    console.log('Sum = ' + reduce(arr, (a, b) => Number(a) + Number(b)));
    console.log('Min = ' + reduce(arr, (a, b) => a < b ? a : b));
    console.log('Max = ' + reduce(arr, (a, b) => a > b ? a : b));
    console.log('Product = ' + reduce(arr, (a, b) => Number(a) * Number(b)));
    console.log('Sum = ' + reduce(arr, (a, b) => '' + a + b));

    function reduce(array, func) {
        let result = array[0];
        for (let nextElement of array.slice(1)) {
            result = func(result, nextElement);
        }

        return result;
    }
}

callAggregates([2, 3, 10, 5]);