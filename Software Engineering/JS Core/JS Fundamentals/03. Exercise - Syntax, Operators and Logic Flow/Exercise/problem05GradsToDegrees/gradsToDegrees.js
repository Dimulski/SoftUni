function calculateDegrees(n) {
    let result = n * 360/400;
    result %= 360;
    if (result < 0) {
        result = 360 + result;
    }
    console.log(result);
}