function solve(input) {
    let landedPlanes = new Set();
    let townsStats = new Map();
    for (let line of input) {
        if (line === '') { // bad input at test 5
            continue;
        }
        let [planeId, town, passengers, action] = line.split(' ');
        passengers = Number(passengers);
        if ((action === 'depart' && !landedPlanes.has(planeId)) || (action === 'land' && landedPlanes.has(planeId))) {
            continue;
        }

        if (!townsStats.has(town)) {
            townsStats.set(town, {arrivals: 0, departures: 0, planes: new Set()});
        }

        if (action === 'land') {
            townsStats.get(town).arrivals += passengers;
            townsStats.get(town).planes.add(planeId);
            landedPlanes.add(planeId);
        } else if (action === 'depart') {
            townsStats.get(town).departures += passengers;
            townsStats.get(town).planes.add(planeId); // teleporting airplanes
            landedPlanes.delete(planeId);
        }
    }

    let result = [];
    result.push('Planes left:');
    Array.from(landedPlanes).sort((a, b) => a.localeCompare(b)).forEach(p => result.push(`- ${p}`));

    let sortedTowns = Array.from(townsStats.entries()).sort((a, b) => {
        if (a[1].arrivals !== b[1].arrivals) {
            return b[1].arrivals - a[1].arrivals;
        } else {
            return a[0].localeCompare(b[0]);
        }
    }).forEach(e => {
        result.push(e[0]);
        result.push(`Arrivals: ${e[1].arrivals}`);
        result.push(`Departures: ${e[1].departures}`);
        result.push('Planes:');
        Array.from(e[1].planes).sort((a, b) => {
            return a.localeCompare(b);
        }).forEach(p => {
            result.push(`-- ${p}`);
        });
    });
    console.log(result.join('\n'));
}