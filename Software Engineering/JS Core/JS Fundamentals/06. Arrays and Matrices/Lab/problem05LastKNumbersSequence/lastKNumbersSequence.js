function lastKNumbersSequence(n, k) {
    let result = [1];
    for (let i = 1; i < k; i++) {
        result.unshift(0);
    }
    for (let i = k; i < n + k - 1; i++) {
        result[i] = sumOfPreviousK(result, i, k);
    }
    for (let i = 1; i < k; i++) {
        result.shift();
    }
    console.log(result.join(' '));

    function sumOfPreviousK(array, index, k) {
        let sum = 0;
        for (let i = 1; i <= k; i++) {
            sum += array[index - 1];
            index--;
        }

        return sum;
    }
}