function modifyAverage(number) {
    let numbers = (number + '').split('');

    while (averageValue(numbers) <= 5) {
        numbers.push(9);
    }
    return numbers.join('');

    function averageValue(numbers) {
        let average = 0;
        for (let num of numbers) {
            average += Number(num);
        }
        return average / numbers.length;
    }
}