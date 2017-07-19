let isOddOrEven = require('../evenOrOdd').isOddOrEven;
let expect = require('chai').expect;
let assert = require('chai').assert;

describe('isOddOrEven(string) - determines if the string has odd or even length', function () {
    it('with a number parameter, should return undefined', function () {
        let expected = undefined;
        let actual = isOddOrEven(13);
        expect(actual).to.equal(expected);
    });

    it('with an object parameter, should return undefined', function () {
        let expected = undefined;
        let actual = isOddOrEven({name: 'pesho'});
        expect(actual).to.equal(expected);
    });

    it('with an even length string, should return correct result', function () {
        let expected = 'even';
        let actual = isOddOrEven('rock');
        assert.equal(actual, expected);
    });

    it('with an odd length string, should return correct result', function () {
        let expected = 'odd';
        let actual = isOddOrEven('metal');
        expect(actual).to.equal(expected);
    });

    it('with multiple consecutive checks, should return correct value', function () {
        expect(isOddOrEven('dog')).to.equal('odd');
        expect(isOddOrEven('ambient')).to.equal('odd');
        expect(isOddOrEven('is it even')).to.equal('even');
    });
});