function countOccurrences(targetString, text) {
    let count = 0;
    let index = text.indexOf(targetString);
    while (index > -1) {
        count++;
        index = text.indexOf(targetString, index + 1);
    }
    return count;
}