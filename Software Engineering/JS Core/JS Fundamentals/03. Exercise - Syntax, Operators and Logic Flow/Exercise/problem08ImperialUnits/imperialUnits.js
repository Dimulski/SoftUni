function convertUnits(inches) {
    let feet = Math.floor(inches / 12);
    let leftInches = inches % 12;
    console.log(feet + "'-" + leftInches + "\"");
}