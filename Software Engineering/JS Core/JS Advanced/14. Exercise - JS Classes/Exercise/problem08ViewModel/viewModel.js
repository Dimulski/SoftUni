class Textbox {
    constructor(selector, invalidSymbolsRegex) {
        this._elements = $(selector);
        this._value = $(this._elements[0]).val();
        this._invalidSymbols = invalidSymbolsRegex;
        this.onInput();
    }

    onInput() {
        this.elements.on('input', (event) => {
            let text = $(event.target).val();
            this.value = text;
        })
    }

    get value() {
        return this._value;
    }

    set value(value) {
        this._value = value;
        for (let element of this.elements) {
            $(element).val(value);
        }
    }

    get elements() {
        return this._elements;
    }

    isValid() {
        if (this._invalidSymbols.test(this.value)) {
            return false;
        } else {
            return true;
        }
    }
}

let textbox = new Textbox('.textbox', /[^a-zA-Z0-9]/);
let inputs = $('.textbox');

inputs.on('input', function () {
    console.log(textbox.value);
});