function solve(button) {
    $(button).click(summarize);

    function summarize() {
        let content = $('#content');
        let parent = content.parent();
        let summary = $(`<div id="summary"><h2>Summary</h2></div>`);
        let summaryPar = $(`<p></p>`);
        summary.append(summaryPar);
        let strong = content.find('strong');

        for (let elem of strong) {
            summaryPar.append(elem.textContent);
        }

        parent.append(summary);
    }
}

solve('#generate');