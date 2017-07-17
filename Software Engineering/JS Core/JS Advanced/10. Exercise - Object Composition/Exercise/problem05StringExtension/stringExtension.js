(function () {
    String.prototype.ensureStart = function (string) {
        if (this.indexOf(string) !== 0) {
            return string + this;
        }
        return this.toString();
    };

    String.prototype.ensureEnd = function (string) {
        if (this.indexOf(string) + string.length !== this.length) {
            return this + string;
        }
        return this.toString();
    };

    String.prototype.isEmpty = function () {
        return this.length === 0;
    };

    String.prototype.truncate = function (numberChars) {
        if (numberChars < 4) {
            return '.'.repeat(numberChars);
        }
        if (this.length > numberChars) {
            let string = this.toString().slice(0, numberChars - 3);
            let lastSpace = string.length;
            if (this.toString()[numberChars - 3] !== ' ' && this.toString()[numberChars - 3] !== undefined) {
                lastSpace = string.lastIndexOf(' ') === -1 ? string.length : string.lastIndexOf(' ');
            }
            return string.slice(0, lastSpace) + '...';
        }
        return this.toString();
    };

    String.format = function (string, ...params) {
        const regexPlaceholder = /{[\d]+}/;
        while (params.length > 0) {
            string = string.replace(regexPlaceholder, params.shift());
        }
        return string;
    };
})();

let string = 'my string';
console.log(string = string.ensureStart('my'));
console.log(string = string.ensureStart('hello '));
console.log(string = string.truncate(16));
console.log(string = string.truncate(14));
console.log(string = string.truncate(8));
console.log(string = string.truncate(4));
console.log(string = string.truncate(2));
console.log(string = String.format('The {0} {1} fox', 'quick', 'brown'));
console.log(string = String.format('jumps {0} {1}', 'dog'));
