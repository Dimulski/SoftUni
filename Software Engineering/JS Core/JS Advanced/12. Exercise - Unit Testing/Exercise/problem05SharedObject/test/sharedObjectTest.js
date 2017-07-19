let expect = require('chai').expect;
let jsdom = require('jsdom-global')();
let $ = require('jquery');

document.body.innerHTML = `<div id="wrapper">
        <input type="text" id="name">
        <input type="text" id="income">
    </div>`;

let sharedObject = {
    name: null,
    income: null,
    changeName: function (name) {
        if (name.length === 0) {
            return;
        }
        this.name = name;
        let newName = $('#name');
        newName.val(this.name);
    },
    changeIncome: function (income) {
        if (!Number.isInteger(income) || income <= 0) {
            return;
        }
        this.income = income;
        let newIncome = $('#income');
        newIncome.val(this.income);
    },
    updateName: function () {
        let newName = $('#name').val();
        if (newName.length === 0) {
            return;
        }
        this.name = newName;
    },
    updateIncome: function () {
        let newIncome = $('#income').val();
        if (isNaN(newIncome) || !Number.isInteger(Number(newIncome)) || Number(newIncome) <= 0) {
            return;
        }
        this.income = Number(newIncome);
    }
};

describe('sharedObject - container of a couple of functions and enclosed variables', function () {
    it('variable should be an object', function () {
        expect(typeof sharedObject).to.equal('object');
    });

    describe('initial values tests', function () {
        it('initial name value should be null', function () {
            expect(sharedObject.name).to.be.null;
        });
        it('initial income value should be null', function () {
            expect(sharedObject.income).to.be.null;
        });
    });

    describe('changeName() tests', function () {
        it('should return null for empty string input', function () {
            sharedObject.changeName('');
            expect(sharedObject.name).to.be.null;
        });
        it('should work correctly for correct input', function () {
            sharedObject.changeName('Pesho');
            expect(sharedObject.name).to.equal('Pesho');
        });

        describe('HTML input name tests', function () {
            it('should return null for empty string input', function () {
                sharedObject.changeName('Nakov');
                sharedObject.changeName('');
                let nameVal = $('#name');
                expect(nameVal.val()).to.be.equal('Nakov');
            });
            it('should work correctly for correct input', function () {
                sharedObject.changeName('Pesho');
                let nameVal = $('#name');
                expect(nameVal.val()).to.equal('Pesho');
            });
        });
    });

    describe('changeIncome() tests', function () {
        it('should not change income for string input', function () {
            sharedObject.changeIncome('invalid');
            expect(sharedObject.income).to.be.null;
        });
        it('should work correctly with correct values', function () {
            sharedObject.changeIncome(10);
            sharedObject.changeIncome(5);
            expect(sharedObject.income).to.be.equal(5);
        });
        it('should work with fractions', function () {
            sharedObject.changeIncome(10);
            sharedObject.changeIncome(5.5);
            expect(sharedObject.income).to.be.equal(10);
        });
        it('should work with negative numbers', function () {
            sharedObject.changeIncome(10);
            sharedObject.changeIncome(-5);
            expect(sharedObject.income).to.be.equal(10);
        });
        it('should work with zero', function () {
            sharedObject.changeIncome(10);
            sharedObject.changeIncome(0);
            expect(sharedObject.income).to.be.equal(10);
        });

        describe('HTML changeIncome() tests', function () {
            it('should not change income for string input', function () {
                sharedObject.changeIncome(10);
                sharedObject.changeIncome('invalid');
                let income = $('#income');
                expect(income.val()).to.equal('10');
            });
            it('should work correctly with correct values', function () {
                sharedObject.changeIncome(10);
                sharedObject.changeIncome(5);
                let income = $('#income');
                expect(income.val()).to.be.equal('5');
            });
            it('should work with fractions', function () {
                sharedObject.changeIncome(10);
                sharedObject.changeIncome(5.5);
                let income = $('#income');
                expect(income.val()).to.be.equal('10');
            });
            it('should work with negative numbers', function () {
                sharedObject.changeIncome(10);
                sharedObject.changeIncome(-5);
                let income = $('#income');
                expect(income.val()).to.be.equal('10');
            });
            it('should work with zero', function () {
                sharedObject.changeIncome(10);
                sharedObject.changeIncome(0);
                let income = $('#income');
                expect(income.val()).to.be.equal('10');
            });
        });
    });

    describe('updateName() tests', function () {
        it('should not change name for empty string input', function () {
            sharedObject.changeName('Pesho');
            lat = nameEl = $('#name');
            nameEl.val('');
            sharedObject.updateName();
            expect(sharedObject.name).to.be.equal('Pesho');
        });
        it('should change name for string input', function () {
            sharedObject.changeName('Pesho');
            lat = nameEl = $('#name');
            nameEl.val('Nakov');
            sharedObject.updateName();
            expect(sharedObject.name).to.be.equal('Nakov');
        });
    });

    describe('updateIncome() tests', function () {
        it('should not change income for string input', function () {
            sharedObject.changeIncome(10);
            let income = $('#income');
            income.val('invalid');
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(10);
        });
        it('should work with fractions', function () {
            sharedObject.changeIncome(10);
            let income = $('#income');
            income.val('5.5');
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(10);
        });
        it('should work with negative numbers', function () {
            sharedObject.changeIncome(10);
            let income = $('#income');
            income.val('-5');
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(10);
        });
        it('should work with zero', function () {
            sharedObject.changeIncome(10);
            let income = $('#income');
            income.val('0');
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(10);
        });
        it('should work correctly with correct params', function () {
            sharedObject.changeIncome(10);
            let income = $('#income');
            income.val('5');
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(5);
        });
    });
});