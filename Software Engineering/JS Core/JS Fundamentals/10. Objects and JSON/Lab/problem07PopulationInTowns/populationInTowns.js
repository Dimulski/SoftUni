function populationInTowns(input) {
    let townsPopulation = new Map();
    for (let line of input) {
        let [town, population] = line.split(' <-> ');
        population = Number(population);
        townsPopulation.has(town) ? townsPopulation.set(town, townsPopulation.get(town) + population)
            : townsPopulation.set(town, population);
    }

    townsPopulation.forEach((k, v) => console.log(`${v} : ${k}`))
}