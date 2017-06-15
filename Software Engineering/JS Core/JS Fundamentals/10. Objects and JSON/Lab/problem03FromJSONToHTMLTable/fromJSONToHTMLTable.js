function JSONToHTMLTable(json) {
    let html = '<table>\n  <tr>';
    let objectArray = JSON.parse(json);
    for (let key of Object.keys(objectArray[0])) {
        html += `<th>${htmlEscape(key)}</th>`;
    }
    html += '</tr>\n';
    for (let obj of objectArray) {
        html += '  <tr>';
        for (let value of Object.values(obj)) {
            html += `<td>${htmlEscape(value.toString())}</td>`;
        }
        html += '</tr>\n';
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