function concatenateAndReverse(array) {
    let allStrings = array.join('');
    let chars = Array.from(allStrings);
    let revChars = chars.reverse();
    let revString = revChars.join('');
    console.log(revString);
}