function templateFormat(input) {
    let html = '<?xml version="1.0" encoding="UTF-8"?>\n<quiz>\n';
    for (let i = 0; i < input.length; i += 2) {
        let question = input[i];
        let answer = input[i + 1];
        html += formatQAndA(question, answer);
    }
    console.log(html + '</quiz>');

    function formatQAndA(question, answer) {
        let html = '  <question>\n    ';
        html += question + '\n';
        html += '  </question>\n  <answer>\n    ';
        html += answer + '\n';
        html += '  </answer>\n';

        return html;
    }
}