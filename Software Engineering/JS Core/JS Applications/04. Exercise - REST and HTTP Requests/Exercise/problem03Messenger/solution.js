function attachEvents() {
    let baseUrl = "https://messenger-c057a.firebaseio.com/messenger";
    let messageBox = $('#messages');
    $('#submit').click(postMessage);
    $('#refresh').click(refresh);

    function postMessage() {
        let name = $('#author');
        let content = $('#content');
        let timestamp = Date.now();
        $.post(baseUrl + '.json',
            JSON.stringify(
                {
                    author: name.val(),
                    content: content.val(),
                    timestamp: timestamp
                })
        ).then(refresh);
        name.val('');
        content.val('');
    }

    function refresh() {
        $.get(baseUrl + '.json').then(displayMessages);
        function displayMessages(res) {
            let messages = [];
            for (let message in res) {
                messages.push(res[message]);
            }
            messages = messages.sort((a,b) => a.timestamp > b.timestamp)
                .map(m => `${m.author}: ${m.content}`).join('\n');

            messageBox.text(messages);
        }
    }
}