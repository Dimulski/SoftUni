function generateSummary(selector) {
    $(selector).on('click', function () {
        let summaryText = $('#content strong').text();
        createSummary(summaryText);
    });
    
    function createSummary(summaryText) {
        let summary = $('<div>');
        summary.attr('id', 'summary');
        let title = $('<h2>Summary<h2>');
        let content = $(`<p>${summaryText}</p>`);

        summary.append(title);
        summary.append(content);
        $('#content').parent().append(summary);
    }
}