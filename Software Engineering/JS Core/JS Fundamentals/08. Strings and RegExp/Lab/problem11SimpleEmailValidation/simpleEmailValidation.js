function validateEmail(email) {
    let pattern = /^[a-zA-Z0-9]+@[a-z]+.[a-z]+$/g;
    let result = pattern.test(email);
    result ? console.log('Valid') : console.log('Invalid');
}