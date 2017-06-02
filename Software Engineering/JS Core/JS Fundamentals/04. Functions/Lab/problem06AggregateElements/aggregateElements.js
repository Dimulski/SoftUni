function aggregateElements(elements) {

    function aggregate(elements, initVal, func) {
        let val = initVal;
        for (let i = 0; i < elements.length; i++) {
            val = func(val, elements[i]);
        }
        console.log(val);
    }

    aggregate(elements, 0, (a, b) => a + b);
    aggregate(elements, 0, (a, b) => a + 1 / b);
    aggregate(elements, '', (a, b) => a + b);
}