function htmlList(items) {
    String.prototype.htmlEscape = function () {
        return this.replace(/&/g, '&amp;')
            .replace(/</g, '&lt;')
            .replace(/>/g, '&gt;')
            .replace(/"/g, '&quot;')
            .replace(/'/g, '&#39;');
    };

    let result = '<ul>\n';
    for (let item of items) {
        result += '\t<li>' + item.htmlEscape() + '</li>\n';
    }
    return result + '</ul>';
}

function htmlListTwo(items) {
    return "<ul>\n" +
        items.map(htmlEscape).map(item =>
            `  <li>${item}</li>`).join("\n") + "\n</ul>\n";

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