function endsWith(string, substring) {
    return string.endsWith(substring);
}

function endsWithRegex(string, substring) {
    let regex = new RegExp(escapeRegExp(substring) + '$');
    return regex.test(string);

    function escapeRegExp(str) {
        return str.replace(/[\-\[\]\/\{\}\(\)\*\+\?\.\\\^\$\|]/g, "\\$&");
    }
}