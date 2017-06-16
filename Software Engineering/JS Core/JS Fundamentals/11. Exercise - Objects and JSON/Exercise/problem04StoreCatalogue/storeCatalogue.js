function organize(input) {
    let letterProducts = new Map();
    for (let productString of input) {
        productString = productString.replace(/ (?=:)/, '');

        if (!letterProducts.has(productString[0])) {
            letterProducts.set(productString[0], []);
        }
        letterProducts.get(productString[0]).push(productString);
    }

    let sorted = [...letterProducts.keys()].sort();
    let counter = 0;
    let result = [];
    while (true) {
        result.push(sorted[counter]);
        let currentLettersProducts = letterProducts.get(sorted[counter++]);
        currentLettersProducts.sort((a, b) => a.toLowerCase().localeCompare(b.toLowerCase())).forEach(v => result.push(`  ${v}`));

        if (counter === sorted.length) {
            break;
        }
    }
    console.log(result.join('\n'));
}