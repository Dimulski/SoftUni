function drawSpiralMatrix(n, m) {
    let total = n * m;
    let matrix = [];

    for (let i = 0; i < n; i++) {
        let row = [];
        for (let j = 0; j < n; j++) {
            row.push(0);
        }
        matrix.push(row);
    }

    let x = 0, y = 0, step = 0;

    for (let i = 0; i < total;) {
        while (y + step < n) {
            i++;
            matrix[x][y] = i;
            y++;
        }
        y--;
        x++;

        while (x + step < n) {
            i++;
            matrix[x][y] = i;
            x++;
        }
        x--;
        y--;

        while (y >= step) {
            i++;
            matrix[x][y] = i;
            y--;
        }
        y++;
        x--;
        step++;

        while (x >= step) {
            i++;
            matrix[x][y] = i;
            x--;
        }
        x++;
        y++;
    }
    matrix.forEach(row => console.log(row.join(' ')));
}