function processCommands(commands) {
    let text = '';
    let processor = function (commands) {
        for (let command of commands) {
            let commandArgs = command.split(' ');
            switch (commandArgs[0]) {
                case 'append':
                    text += commandArgs[1];
                    break;
                case 'removeStart':
                    text = text.slice(Number(commandArgs[1]));
                    break;
                case 'removeEnd':
                    text = text.slice(0, text.length - Number(commandArgs[1]));
                    break;
                case 'print':
                    console.log(text);
                    break;
            }
        }
    };

    return processor(commands);
}

processCommands(['append hello', 'append again', 'removeStart 3', 'removeEnd 4', 'print']);
