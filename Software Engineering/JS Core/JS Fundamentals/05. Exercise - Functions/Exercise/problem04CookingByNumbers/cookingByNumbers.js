function cookByNumbers(input) {
    let [number, op1, op2, op3, op4, op5] =
        [Number(input[0]), input[1], input[2], input[3], input[4], input[5]];

    let chop = (num) => num / 2;
    let dice = (num) => Math.sqrt(num);
    let spice = (num) => ++num;
    let bake = (num) => num * 3;
    let fillet = (num) => num -= num * 0.2;

    for (let op of [op1, op2, op3, op4, op5]) {
        switch (op) {
            case 'chop':
                number = chop(number);
                break;
            case 'dice':
                number = dice(number);
                break;
            case 'spice':
                number = spice(number);
                break;
            case 'bake':
                number = bake(number);
                break;
            case 'fillet':
                number = fillet(number);
                break;
        }
        console.log(number);
    }
}

cookByNumbers([9, 'dice', 'spice', 'chop', 'bake', 'fillet']);