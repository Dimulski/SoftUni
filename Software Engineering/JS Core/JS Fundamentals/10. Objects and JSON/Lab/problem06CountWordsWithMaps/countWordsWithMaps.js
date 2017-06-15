function countWords(inputLines) {
    let text = inputLines.join('\n').toLowerCase();
    let map = new Map();
    for (let word of text.split(/\W+/).filter(w => w != '')) {
        map.has(word) ? map.set(word, map.get(word) + 1) : map.set(word, 1);
    }
    let sortedWords = Array.from(map.keys()).sort();
    sortedWords.forEach(w => console.log(`'${w}' -> ${map.get(w)} times`));
}