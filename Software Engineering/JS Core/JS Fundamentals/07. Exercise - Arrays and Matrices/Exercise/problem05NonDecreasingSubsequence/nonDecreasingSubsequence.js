function extractSubsequence(array) {
    let currentBiggest = array[0];
    let result = [currentBiggest];
    for (let i = 1; i < array.length; i++) {
        if (array[i] >= currentBiggest) {
            result.push(array[i]);
            currentBiggest = array[i];
        }
    }

    result.forEach(e => console.log(e));
}

extractSubsequence([1,
    3,
    8,
    4,
    10,
    12,
    3,
    2,
    24
])