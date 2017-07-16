function processCommands(commands) {
    let commandProcessor = (function() {
        let list = [];
        return {
            add: (newItem) => list.push(newItem),
            remove: (item) =>
                list = list.filter(x => x !== item),
            print: () => console.log(list)
        }
    })();

    for (let cmd of commands) {
        let [cmdName, arg] = cmd.split(' ');
        commandProcessor[cmdName](arg);
    }
}

function processCommandsAlt(commands) {
    let executor = getCommandExecutor();
    commands.forEach(c => executor(c));

    function getCommandExecutor() {
        let array = [];

        return function (command) {
            let commandArgs = command.split(' ');
            switch (commandArgs[0]) {
                case 'add':
                    array.push(commandArgs[1]);
                    break;
                case 'remove':
                    array = array.filter(x => x !== commandArgs[1]);
                    break;
                case 'print':
                    console.log(array.join(','));
                    break;
            }
        }
    }
}

processCommands(['add hello', 'add again', 'remove hello', 'add again', 'print']);
