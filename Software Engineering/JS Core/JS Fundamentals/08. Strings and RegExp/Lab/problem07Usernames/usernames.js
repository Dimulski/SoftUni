function generateUsername(emails) {
    let usernames = [];
    for (let email of emails) {
        let [localPart, domain] = email.split('@');
        let username = localPart + '.';
        let domainParts = domain.split('.');
        domainParts.forEach(p => username += p[0]);
        usernames.push(username);
    }

    return usernames.join(', ');
}