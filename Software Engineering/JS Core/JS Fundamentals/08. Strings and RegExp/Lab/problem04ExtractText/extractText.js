function extractText(string) {
    let extractedStrings = [];
    let startIndex = string.indexOf('(');
    while (startIndex > -1) {
        let endIndex = string.indexOf(')', startIndex);
        if (endIndex == -1) {
            break;
        }
        extractedStrings.push(string.substring(startIndex + 1, endIndex));
        startIndex = string.indexOf('(', endIndex + 1);
    }
    return extractedStrings.join(', ');
}