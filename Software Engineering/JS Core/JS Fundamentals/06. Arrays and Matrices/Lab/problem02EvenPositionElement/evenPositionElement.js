function evenPositions(array) {
    resultArray = [];
    for (let i in array) {
        if (i % 2 === 0) {
            resultArray.push(array[i]);
        }
    }
    return resultArray.join(' ');
}