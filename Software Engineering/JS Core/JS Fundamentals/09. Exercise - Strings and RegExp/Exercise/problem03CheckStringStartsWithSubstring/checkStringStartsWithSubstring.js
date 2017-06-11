function startsWith(string, substring) {
    return string.startsWith(substring);
}

function startsWithRegex(string, substring) {
    let regex = new RegExp('^' + escapeRegExp(substring));
    return regex.test(string);

    function escapeRegExp(str) {
        return str.replace(/[\-\[\]\/\{\}\(\)\*\+\?\.\\\^\$\|]/g, "\\$&");
    }
}