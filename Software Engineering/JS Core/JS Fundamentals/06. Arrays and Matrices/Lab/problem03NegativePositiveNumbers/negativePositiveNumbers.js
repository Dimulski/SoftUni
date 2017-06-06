function rearrangeNumbers(array) {
    let resultArray = [];
    for (let i = 0; i < array.length; i++) {
        if (array[i] < 0) {
            resultArray.unshift(array[i]);
        } else {
            resultArray.push(array[i]);
        }
    }
    console.log(resultArray.join('\n'));
}

rearrangeNumbers([7, -2, 8, 9]);