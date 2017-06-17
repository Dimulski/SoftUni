function solve(wall) {
    wall = wall.map(Number);
    let dailyConcreteUsage = [];
    while (true) {
        let dailyConcrete = 0;
        for (let i = 0; i < wall.length; i++) {
            if (wall[i] === 30) {
                continue;
            }

            wall[i] += 1;
            dailyConcrete += 195;
        }
        dailyConcreteUsage.push(dailyConcrete);
        if (wall.reduce((a, b) => a + b) === 30 * wall.length) {
            break;
        }
    }
    let totalConcrete = dailyConcreteUsage.reduce((a, b) => a + b);
    let pesos = 1900 * totalConcrete;
    console.log(dailyConcreteUsage.join(', '));
    console.log(pesos + ' pesos');
}