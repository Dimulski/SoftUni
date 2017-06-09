function aggregateTable(array) {
    let towns = [];
    let sum = 0;
    for (let element of array) {
        let [townString, incomeString] = element.split('|').filter(s => s !== '');
        let town = townString.trim();
        let income = Number(incomeString.trim());
        towns.push(town);
        sum += income;
    }
    return towns.join(', ') + '\n' + sum;
}

console.log(aggregateTable(['| Sofia           | 300',
    '| Veliko Tarnovo  | 500',
    '| Yambol          | 275']
));