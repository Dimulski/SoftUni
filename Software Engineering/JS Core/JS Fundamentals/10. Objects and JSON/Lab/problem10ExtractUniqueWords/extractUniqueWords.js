function extractUniqueWords(input) {
    let words = input.join('\n').toLowerCase().split(/\W+/).filter(w => w != '');
    let wordSet = new Set();
    for (word of words) {
        wordSet.add(word);
    }
    return [...wordSet.values()].join(', ');
}