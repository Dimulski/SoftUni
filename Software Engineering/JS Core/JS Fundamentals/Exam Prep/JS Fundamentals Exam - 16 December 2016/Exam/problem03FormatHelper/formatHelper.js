function solve(textArray) {
    let text = textArray[0];
    text = text.replace(/([.,!?:;])\s*/g, "$1 ");
    text = text.replace(/\s+([.,!?:;])/g, "$1");
    text = text.replace(/\.\s+(?=\d)/g, '.');
    text = text.replace(/"\s*(.+?)\s*"/g, `\"$1\"`);
    console.log(text.trim());

}