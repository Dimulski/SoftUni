function convert(JSONInput) {
    let html = '<table>\n';
    for (let JSONString of JSONInput) {
        let object = JSON.parse(JSONString);
        html += '\t<tr>\n';
        Object.values(object).forEach(v => html += `\t\t<td>${v}</td>\n`); // escape goes in forEach
        html += '\t<tr>\n';
    }
    html += '</table>';

    console.log(html);

    function htmlEscape(text) {
        let map = {
            '"': '&quot;',
            '&': '&amp;',
            "'": '&#39;',
            '<': '&lt;',
            '>': '&gt;' };
        return text.replace(/[\"&'<>]/g, ch => map[ch]);
    }
}