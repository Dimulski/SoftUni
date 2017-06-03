function solve([speed, area]) {
    let limit = getLimit(area);
    let infraction = getInfraction(speed, limit);
    if (infraction) {
        console.log(infraction);
    }

    function getInfraction(speed, limit) {
        let overSpeed = speed - limit;
        if (overSpeed > 0) {
            if (overSpeed <= 20) {
                return 'speeding';
            } else if (overSpeed <= 40) {
                return "excessive speeding";
            } else if (overSpeed > 40) {
                return "reckless driving";
            }
        }
    }

    function getLimit(area) {
        switch (area) {
            case 'motorway':
                return 130;
            case 'interstate':
                return 90;
            case 'city':
                return 50;
            case 'residential':
                return 20;
        }
    }
}