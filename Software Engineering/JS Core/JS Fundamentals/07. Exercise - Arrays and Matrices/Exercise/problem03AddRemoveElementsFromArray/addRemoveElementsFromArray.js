function addRemoveElementsFromArray(input) {
    let resultArray = [];
    let n = 1;
    for (let element of input) {
        switch (element) {
            case "add":
                resultArray.push(n++);
                break;
            case "remove":
                resultArray.pop();
                n++;
                break;
        }
    }

    return resultArray.length === 0 ? 'Empty' : resultArray.forEach(e => console.log(e));
}