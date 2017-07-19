let lookupChar = require('../charLookup').lookupChar;
let expect = require('chai').expect;

describe('lookupChar(string, index) - returns the the character at position "index" of "string"', function () {
    it('with a non-string first parameter, should return undefined', function () {
        let expected = undefined;
        let actual = lookupChar(13, 0);
        expect(actual).to.equal(expected);
    });

    it('with a non-number second parameter, should return undefined', function () {
        let expected = undefined;
        let actual = lookupChar('pesho', 'gosho');
        expect(actual).to.equal(expected);
    });

    it('with a floating point number second parameter, should return undefined', function () {
        let expected = undefined;
        let actual = lookupChar('pesho', 3.12);
        expect(actual).to.equal(expected);
    });

    it('with an incorrect index value, should return incorrect index', function () {
        let expected = 'Incorrect index';
        let actual = lookupChar('pesho', 13);
        expect(actual).to.equal(expected);
    });

    it('with a negative index value, should return incorrect index', function () {
        let expected = 'Incorrect index';
        let actual = lookupChar('pesho', -1);
        expect(actual).to.equal(expected);
    });

    it('with an index value equal to string length, should return incorrect index', function () {
        let expected = 'Incorrect index';
        let actual = lookupChar('pesho', 5);
        expect(actual).to.equal(expected);
    });

    it("with correct parameters, should return correct value", function () {
        let expected = 'p';
        let actual = lookupChar('pesho', 0);
        expect(actual).to.equal(expected);
    });

    it("with correct parameters, should return correct value", function () {
        let expected = 'm';
        let actual = lookupChar('stamat', 3);
        expect(actual).to.equal(expected);
    });
});