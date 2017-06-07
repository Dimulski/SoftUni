function rotateArray(array) {
    let n = Number(array.pop());
    let shortenedN = n % array.length;
    for (let i = 0; i < shortenedN; i++) {
        let element = array.pop();
        array.unshift(element);
    }

    return array.join(' ');
}