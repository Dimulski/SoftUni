class Rat {
    constructor(name) {
        this.name = name;
        this.unitedRats = [];
    }

    unite(rat) {
        if (rat instanceof Rat) {
            this.unitedRats.push(rat)
        }
    };

    getRats() {
        return this.unitedRats;
    }

    toString() {
        if (this.unitedRats.length === 0) {
            return this.name;
        } else {
            let result = this.name + '\n';
            for (let rat of this.unitedRats) {
                result += `##${rat}\n`;
            }
            return result;
        }
    }
}

let test = new Rat("Pesho");
console.log(test.toString());

console.log(test.getRats());

test.unite(new Rat("Gosho"));
test.unite(new Rat("Sasho"));
console.log(test.getRats());

console.log(test.toString());
