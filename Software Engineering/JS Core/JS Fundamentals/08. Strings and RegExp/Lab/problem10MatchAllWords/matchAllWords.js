function matchAllWords(text) {
    return text.split(/\W+/).filter(e => e !== '').join('|');
}