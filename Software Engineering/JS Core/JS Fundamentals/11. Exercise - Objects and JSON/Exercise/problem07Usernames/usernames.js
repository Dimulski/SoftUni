function catalogueUsernames(input) {
    let usernames = new Set();
    for (let username of input) {
        usernames.add(username);
    }
    let result = [];
    let sortedUsernames = Array.from(usernames).sort((a, b) => {
        if (a.length !== b.length) {
            return a.length - b.length;
        } else {
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
            return 0;
        }
    }).forEach(u => result.push(u));

    console.log(result.join('\n'));
}