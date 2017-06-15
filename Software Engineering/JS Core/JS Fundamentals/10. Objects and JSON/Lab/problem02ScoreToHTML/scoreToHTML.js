function scoreToHTMLTable(scoresJSON) {
    let html = '<table>\n  <tr><th>name</th><th>score</th></tr>\n';
    let scoresObjArray = JSON.parse(scoresJSON);
    for (let score of scoresObjArray) {
        html += `  <tr><td>${htmlEscape(score['name'])}</td><td>${score['score']}</td></tr>\n`;
    }
    html += '</table>';
    return html;

    function htmlEscape(text) {
        let map = {
            '"': '&quot;',
            '&': '&amp;',
            "'": '&#39;',
            '<': '&lt;',
            '>': '&gt;'
        };
        return text.replace(/[\"&'<>]/g, ch => map[ch]);
    }
}