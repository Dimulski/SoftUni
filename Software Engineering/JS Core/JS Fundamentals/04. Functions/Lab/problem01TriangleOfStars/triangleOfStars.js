function printTriangle(n) {
    function printStars(count) {
        console.log("*".repeat(count));
    }
    for (i = 1; i <= n; i++) {
        printStars(i);
    }
    for (i = n - 1; i >= 1; i--) {
        printStars(i);
    }
}