function censor(text, words) {
    for (let word of words) {
        while (text.indexOf(word) > -1) {
            text = text.replace(word, '-'.repeat(word.length));
        }
    }
    return text;
}