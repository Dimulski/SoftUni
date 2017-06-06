function equalNeighborsCount(matrix) {
    matrix.push([]);
    for (let i = 0; i < matrix[0].length; i++) {
        matrix[matrix.length - 1].push(NaN);
    }
    let neighbors = 0;
    for (let row = 0; row < matrix.length - 1; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            if (matrix[row][col] == matrix[row + 1][col]) {
                neighbors++;
            }
            if (matrix[row][col] == matrix[row][col + 1]) {
                neighbors++;
            }
        }
    }
    console.log(neighbors);
}