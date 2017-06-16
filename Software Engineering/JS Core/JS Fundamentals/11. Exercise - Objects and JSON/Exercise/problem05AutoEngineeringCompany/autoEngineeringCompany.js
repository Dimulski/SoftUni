function carRegistry(input) {
    let brandsCars = new Map();
    for (let line of input) {
        let [brand, model, quantity] = line.split(' \| ');
        quantity = Number(quantity);

        if (!brandsCars.has(brand)) {
            brandsCars.set(brand, new Map());
        }
        if (!brandsCars.get(brand).has(model)) {
            brandsCars.get(brand).set(model, 0);
        }

        brandsCars.get(brand).set(model, brandsCars.get(brand).get(model) + quantity);
    }

    result = [];
    // [...brandsCars].forEach(([brand,models]) => {
    //     result.push(brand);
    //     [...models].forEach(([model,amount]) => {
    //         result.push(`###${model} -> ${amount}`);
    //     })
    // });
    for (let kv of brandsCars) {
        result.push(kv[0]);
        for (let innerKv of kv[1]) {
            result.push(`###${innerKv[0]} -> ${innerKv[1]}`);
        }
    }

    console.log(result.join('\n'));
}