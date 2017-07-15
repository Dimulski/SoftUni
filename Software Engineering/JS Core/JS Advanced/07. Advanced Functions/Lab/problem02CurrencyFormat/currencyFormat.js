function formatCurrency(separator, symbol, symbolFirst, value) {
    let result = Math.trunc(value) + separator;
    result += value.toFixed(2).substr(-2, 2);
    if (symbolFirst) {
        return symbol + ' ' + result;
    } else {
        return result + ' ' + symbol;
    }
}

function getDollarFormatter(formatter) {
    let result = function (value) {
        return formatter(',', '$', true, value);
    };

    return result;
}

let dollars = getDollarFormatter(formatCurrency);

console.log(dollars(5345));