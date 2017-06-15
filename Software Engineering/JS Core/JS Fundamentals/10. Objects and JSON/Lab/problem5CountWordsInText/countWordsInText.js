function countWords(text) {
    let words = {};
    for (let sentence of text) {
        for (let word of sentence.split(/\W+/).filter(w => w != '')) {
            if (words[word] === undefined) {
                words[word] = 1;
            } else {
                words[word] += 1;
            }
        }
    }

    return JSON.stringify(words);
}