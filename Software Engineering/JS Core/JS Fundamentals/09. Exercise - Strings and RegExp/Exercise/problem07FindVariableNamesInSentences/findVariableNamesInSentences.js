function findVariableNames(text) {
    let names = [];
    let regex = /\b_([a-zA-Z0-9]+)\b/g;
    let match = regex.exec(text);
    while (match) {
        names.push(match[1]);
        match = regex.exec(text);
    }
    return names.join(',');
}