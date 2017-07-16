let f = (function () {
    let robot = {
        protein: 0,
        carbohydrate: 0,
        fat: 0,
        flavour: 0
    };

    let products = {
        apple: {
            carbohydrate: 1,
            flavour: 2
        },
        coke: {
            carbohydrate: 10,
            flavour: 20,
        },
        burger: {
            carbohydrate: 5,
            fat: 7,
            flavour: 3
        },
        omelet: {
            protein: 5,
            fat: 1,
            flavour: 1
        },
        cheverme: {
            protein: 10,
            carbohydrate: 10,
            fat: 10,
            flavour: 10
        }
    };

    return function (input) {
        let data = input.split(' ');
        let command = data[0];
        switch (command) {
            case 'restock': {
                let microElement = data[1];
                let elementQuantity = Number(data[2]);

                robot[microElement] += elementQuantity;
                return 'Success';
            }
            case 'report': {
                return `protein=${robot.protein} carbohydrate=${robot.carbohydrate} fat=${robot.fat} flavour=${robot.flavour}`;
            }
            case 'prepare': {
                let product = data[1];
                let productQuantity = Number(data[2]);
                let currentProductStats = products[product];

                for (let microElement in currentProductStats) {
                    let elementQantity = currentProductStats[microElement];
                    if (robot[microElement] < elementQantity * productQuantity) {
                        return `Error: not enough ${microElement} in stock`;
                    }
                }

                for (let microElement in currentProductStats) {
                    let elementQantity = currentProductStats[microElement];
                    robot[microElement] -= elementQantity * productQuantity;
                }
                return 'Success';
            }
        }
    }
})();

console.log(f('restock flavour 50'));
console.log(f('prepare coke 4'));