function findOccurrences(text, word) {
    let regex = new RegExp('\\b' + word + '\\b', 'ig');
    let matches = text.match(regex);
    return matches === null ? 0 : matches.length;
}