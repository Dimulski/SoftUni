function createCar(carSpecs) {
    let car = {model: carSpecs.model};
    let smallEngine = {power: 90, volume: 1800};
    let normalEngine = {power: 120, volume: 2400};
    let monsterEngine = {power: 200, volume: 3500};
    let carriageContainer = {
        hatchback: {type: 'hatchback', color: carSpecs.color},
        coupe: {type: 'coupe', color: carSpecs.color}
    };

    carSpecs.wheelsize % 2 === 0 ? carSpecs.wheelsize-- : carSpecs.wheelsize;

    if (carSpecs.power <= 90) {
        car.engine = smallEngine;
    } else if (carSpecs.power <= 120) {
        car.engine = normalEngine;
    } else {
        car.engine = monsterEngine;
    }

    car.carriage = carriageContainer[carSpecs.carriage];
    car.wheels = [carSpecs.wheelsize, carSpecs.wheelsize, carSpecs.wheelsize, carSpecs.wheelsize];

    return car;
}

console.log(createCar({
        model: 'VW Golf II',
        power: 90,
        color: 'blue',
        carriage: 'hatchback',
        wheelsize: 14
    }
));
