function solve(input) {
    input = input.map(Number);
    input.push(1);
    let maxSum = Number.MIN_SAFE_INTEGER;
    for (let i = 0; i < input.length - 1; i++) {
        if (input[i] >= 0 && input[i] < 10) {
            let currentSum = 1;
            for (let j = 1; j <= input[i]; j++) {
                currentSum *= input[i + j];
            }
            if (maxSum < currentSum) {
                maxSum = currentSum;
            }
        }
    }
    return maxSum;
}

console.log(solve([
    '18',
    '42',
    '19',
    '36',
    '1',
    '-297',
    '38',
    '100',
    '9',
    '-249',
    '-170',
    '-18',
    '-208',
    '-11',
    '-87',
    '-90',
    '-286',
    '-27'
]))