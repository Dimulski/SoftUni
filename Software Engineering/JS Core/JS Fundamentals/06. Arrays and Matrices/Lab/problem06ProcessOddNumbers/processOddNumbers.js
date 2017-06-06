function processOddNumbers(array) {
    let result = array
        .filter((num, i) => i % 2 == 1)
        .map(x => x * 2)
        .reverse();
    return result.join(' ');
}