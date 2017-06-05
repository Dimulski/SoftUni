function locateTreasure(input) {

    let isOnTuvalu = (x, y) => x <= 3 && x >= 1 && y <= 3 && y >= 1;
    let isOnTonga = (x, y) => x <= 2 && x >= 0 && y <= 8 && y >= 6;
    let isOnSamoa = (x, y) => x <= 7 && x >= 5 && y <= 6 && y >= 3;
    let isOnCook = (x, y) => x <= 9 && x >= 4 && y <= 8 && y >= 7;
    let isOnTokelau = (x, y) => x <= 9 && x >= 8 && y <= 1 && y >= 0;

    for (let i = 0; i < input.length; i += 2) {
        let x = input[i];
        let y = input[i + 1];
        console.log(getLocation(x, y));
    }

    function getLocation(x, y) {
        if (isOnTuvalu(x, y)) {
            return 'Tuvalu';
        } else if (isOnTonga(x, y)) {
            return 'Tonga';
        } else if (isOnSamoa(x, y)) {
            return 'Samoa';
        } else if (isOnCook(x, y)) {
            return 'Cook';
        } else if (isOnTokelau(x, y)) {
            return 'Tokelau';
        } else {
            return 'On the bottom of the ocean';
        }
    }
}