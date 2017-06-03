function validityChecker([x1, y1, x2, y2]) {
    console.log(isValidDistance(x1, y1, 0, 0));
    console.log(isValidDistance(x2, y2, 0, 0));
    console.log(isValidDistance(x1, y1, x2, y2));

    function isValidDistance(x1, y1, x2, y2) {
        let d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if (d % 1 === 0) {
            return '{' + x1 + ', ' + y1 + '} to {' + x2 + ', ' + y2 + '} is valid';
        } else {
            return '{' + x1 + ', ' + y1 + '} to {' + x2 + ', ' + y2 + '} is invalid';
        }
    }
}