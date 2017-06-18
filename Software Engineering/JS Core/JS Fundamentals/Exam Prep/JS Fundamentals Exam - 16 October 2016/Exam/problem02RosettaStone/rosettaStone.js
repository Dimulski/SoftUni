function solve(input) {
    let templateMatrixSide = Number(input[0]);
    let templateMatrix = [];
    for (var index = 1; index < 1 + templateMatrixSide; index++) {
        var currentRow = input[index];
        templateMatrix.push(currentRow.split(' ').map(Number))
    }

    let encodedMatrix = [];
    for (var index = 1 + templateMatrixSide; index < input.length; index++) {
        var currentRow = input[index];
        encodedMatrix.push(currentRow.split(' ').map(Number))
    }

    for (var encodedCol = 0; encodedRow < encodedMatrix.length; encodedRow += templateMatrixSide) {

        var currentEncodedNumber = encodedMatrix[encodedRow][encodedCol];

        for (var templateRow = 0; templateRow < templateMatrix.length; templateRow++) {
            var currentTemplateRow = templateMatrix[templateRow];
            for (var templateCol = 0; templateCol < templateMatrix[templateRow].length; templateCol++) {
                var currentTemplateNumber = templateMatrix[templateRow][templateCol];

                let targetRow = encodedRow + templateRow;
                let targetCol = encodedCol + templateCol;

                if (targetCol < encodedMatrix[targetRow][targetCol] + templateMatrix[templateRow][templateCol]) {
                    summedNumber %= 27;
                    if (summedNumber === 0) {
                        encodedMatrix[targetRow][targetCol] = ' ';
                    } else {
                        encodedMatrix[targetRow][targetCol] = String.fromCharCode(summedNumber + 64);
                    }
                }
            }
        }
    }


    let output = '';
    encodedMatrix.forEach(function (element) {
        element.forEach(function (letter) {
            output += letter
        }, this);
    }, this);

    console.log(output.trim())
}