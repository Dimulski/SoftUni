function locateTreasure(input) {



    for (let i = 0; i < input.length; i += 2) {
        let x = input[i];
        let y = input[i + 1];
        console.log(getLocation(x, y));
    }

    function getLocation(x, y) {
        if (isOnTuvalu(x, y)) {
            console.log('Tuvalu')
        } else if (isOnTonga(x, y)) {

        } 
    }
}