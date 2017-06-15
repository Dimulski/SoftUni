function lowestPricesInCities(input) {
    let map = new Map();
    for (let line of input) {
        let [town, product, price] = line.split(' | ');
        price = Number(price);

        if (!map.has(product)) {
            map.set(product, new Map);
        }

        if (!map.get(product).has(town)) {
            map.get(product).set(town, price);
        } else {
            map.delete(town);
            map.get(product).set(town, price);
        }
    }

    for (let [product, insideMap] of map) {
        let minPrice = Number.MAX_SAFE_INTEGER;
        let townWithLowestPrice = '';
        for (let [town, price] of insideMap) {
            if(Number(price) < minPrice) {
                minPrice = price;
                townWithLowestPrice = town;
            }
        }
        console.log(`${product} -> ${minPrice} (${townWithLowestPrice})`);
    }
}