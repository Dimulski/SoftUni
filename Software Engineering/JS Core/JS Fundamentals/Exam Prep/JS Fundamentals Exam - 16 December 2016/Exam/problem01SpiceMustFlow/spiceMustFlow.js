function solve(yield) {
    let totalSpice = 0;
    let days = 0;
    while (yield >= 100) {
        totalSpice += yield;
        yield -= 10;
        totalSpice -= 26;
        days++;
    }
    totalSpice -= 26;
    if (totalSpice < 0) {
        totalSpice = 0;
    }
    console.log(days);
    console.log(totalSpice);
}