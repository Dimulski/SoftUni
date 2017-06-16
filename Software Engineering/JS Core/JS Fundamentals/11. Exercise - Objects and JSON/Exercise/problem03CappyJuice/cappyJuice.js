function cappyJuice(input) {
    let juiceQuantity = new Map();
    let juiceBottles = new Map();
    for (let juiceString of input) {
        let [juice, quantity] = juiceString.split(' => ');
        quantity = Number(quantity);

        if (!juiceQuantity.has(juice)) {
            juiceQuantity.set(juice, 0);
        }

        juiceQuantity.set(juice, juiceQuantity.get(juice) + quantity);
        if (juiceQuantity.get(juice) >= 1000) {
            let currentQuantity = juiceQuantity.get(juice);
            let bottles = Math.floor(currentQuantity / 1000);
            let remainder = currentQuantity % 1000;

            if (!juiceBottles.has(juice)) {
                juiceBottles.set(juice, 0);
            }

            juiceBottles.set(juice, juiceBottles.get(juice) + bottles);
            juiceQuantity.set(juice, remainder);
        }
    }

    for (let [juice, bottles] of juiceBottles) {
        console.log(`${juice} => ${bottles}`);
    }
}