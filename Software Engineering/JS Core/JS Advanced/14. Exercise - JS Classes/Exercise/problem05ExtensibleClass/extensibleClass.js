(function () {
    let id = 0;

    return class Extensible {
        constructor() {
            this.id = id++;
        }

        extend(template) {
            for (let property in template) {
                if (template.hasOwnProperty(property)) {
                    let value = template[property];
                    if (typeof value === "function") {
                        Extensible.prototype[property] = value;
                    } else {
                        this[property] = value;
                    }
                }
            }
        }
    }
})();