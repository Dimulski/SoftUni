function cityMarkets(strArr) {
    let summary = new Map();

    for (let row of strArr) {
        let [town, product, sales] = row.split(' -> ');
        sales = sales.split(' : ').reduce((a, b) => a * b);

        if (!summary.has(town)) {
            summary.set(town, new Map());
        }
        if (!summary.get(town).has(product)) {
            summary.get(town).set(product, 0);
        }

        let oldSales = summary.get(town).get(product);
        summary.get(town).set(product, oldSales + sales);
    }

    for (let [town, products] of summary) {
        console.log(`Town - ${town}`);
        for (let [product, sales] of products) {
            console.log(`$$$${product} : ${sales}`);
        }
    }
}