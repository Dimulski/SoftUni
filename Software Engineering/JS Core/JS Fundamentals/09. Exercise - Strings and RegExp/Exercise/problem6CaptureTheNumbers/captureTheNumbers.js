function captureTheNumbers(input) {
    let text = input.join(' ');
    let regex = /\d+/g;
    let numbers = text.match(regex);
    console.log(numbers.join(' '));
}