let createCalculator = require('../addSubtract').createCalculator;
let expect = require('chai').expect;

describe("createCalculator() - creates a container for 3 functions", function() {
    let calc;
    beforeEach(function() {
        calc = createCalculator();
    });

    it('should return 0 after create()', function () {
        let expected = 0;
        let actual = calc.get();
        expect(actual).to.be.equal(expected);
    });

    it("should return 5 after {add 2; add 3}", function() {
        let expected = 5;
        calc.add(2);
        calc.add(3);
        let actual = calc.get();
        expect(actual).to.be.equal(expected);
    });

    it("should return -5 after {subtract 2; subtract 3}", function() {
        let expected = -5;
        calc.subtract(2);
        calc.subtract(3);
        let actual = calc.get();
        expect(actual).to.be.equal(expected);
    });

    it("should return close to 4.2 after {add 5.3; subtract 1.1}", function() {
        let expected = 4.2;
        calc.add(5.3);
        calc.subtract(1.1);
        let actual = calc.get();
        expect(actual).to.be.closeTo(expected,  0.1);
    });

    it("should return 2 after {add 10; subtract 7; add -2; subtract -1}", function() {
        let expected = 2;
        calc.add(10);
        calc.subtract(7);
        calc.add(-2);
        calc.subtract(-1);
        let actual = calc.get();
        expect(actual).to.be.equal(expected);
    });

    it('should return 1 after {add "-2"; subtract "-3"}', function () {
        let expected = 1;
        calc.add('-2');
        calc.subtract('-3');
        let actual = calc.get();
        expect(actual).to.equal(expected);
    });

    it("should return NaN after {add 'hello'}", function() {
        calc.add('hello');
        let actual = calc.get();
        expect(actual).to.be.NaN;
    });

    it("should return NaN after {subtract 'hello'}", function() {
        calc.subtract('hello');
        let actual = calc.get();
        expect(actual).to.be.NaN;
    });
});
