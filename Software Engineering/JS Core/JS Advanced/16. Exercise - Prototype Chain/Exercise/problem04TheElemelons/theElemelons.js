function solve() {
    class Melon {
        constructor(weight, melonSort) {
            if (new.target === Melon) {
                throw new TypeError('Abstract class cannot be instantiated directly');
            }
            this.weight = weight;
            this.melonSort = melonSort;
            this._elementIndex = this.weight * this.melonSort.length;
        }

        get weight() {
            return this._weight;
        }

        set weight(weight) {
            this._weight = weight;
        }

        get melonSort() {
            return this._melonSort;
        }

        set melonSort(melonSort) {
            this._melonSort = melonSort;
        }

        get elementIndex() {
            return this._elementIndex;
        }

        toString() {
            return `Sort: ${this.melonSort}\nElement Index: ${this.elementIndex}`;
        }
    }

    class Watermelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
        }

        toString() {
            return `Element: Water\n${super.toString()}`;
        }
    }

    class Firemelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
        }

        toString() {
            return `Element: Fire\n${super.toString()}`;
        }
    }

    class Earthmelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
        }

        toString() {
            return `Element: Earth\n${super.toString()}`;
        }
    }

    class Airmelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
        }

        toString() {
            return `Element: Air\n${super.toString()}`;
        }
    }

    class Melolemonmelon extends Watermelon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this._elements = ['Fire', 'Earth', 'Air', 'Water'];
            this._element = 'Water';
        }

        morph(){
            this._element = this._elements.shift();
            this._elements.push(this._element);
        }

        toString(){
            return `Element: ${this._element}\nSort: ${this.melonSort}\nElement Index: ${this.elementIndex}`;
        }
    }

    return {
        Melon,
        Watermelon,
        Firemelon,
        Earthmelon,
        Airmelon,
        Melolemonmelon
    }
}
