function capitalizeWords(sentence) {
    let result = [];
    sentence.split(' ').forEach(s => result.push(s[0].toUpperCase() + s.slice(1).toLowerCase()));
    return result.join(' ');
}