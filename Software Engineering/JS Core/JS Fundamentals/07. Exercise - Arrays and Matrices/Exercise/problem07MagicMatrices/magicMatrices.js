function isMagicMatrix(matrix) {
    let magicNumber = matrix[0].reduce((a, b) => a + b);
    for (let row = 0; row < matrix.length; row++) {
        if (matrix[row].reduce((a, b) => a + b) != magicNumber) {
            return false;
        }
    }

    for (let col = 0; col < matrix[0].length; col++) {
        let rowSum = 0;
        for (let row = 0; row < matrix.length; row++) {
            rowSum += matrix[row][col];
        }
        if (rowSum != magicNumber) {
            return false;
        }
    }

    return true;
}