function extractLinks(input) {
    let text = input.join(' ');
    let regex = /www\.[a-zA-Z0-9-]+(\.[a-z]+)+/g;
    let numbers = text.match(regex);
    return numbers === null ? '' : numbers.join('\n');
}