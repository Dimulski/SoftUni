function sumByTown(inputArray) {
    let towns = {};
    for (let i = 0; i < inputArray.length - 1; i += 2) {
        if (towns[inputArray[i]] === undefined) {
            towns[inputArray[i]] = 0;
        }
        towns[inputArray[i]] += Number(inputArray[i + 1]);
    }

    return JSON.stringify(towns);
}