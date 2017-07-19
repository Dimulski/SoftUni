let rgbToHexColor = require('../rgbToHex').rgbToHexColor;
let expect = require('chai').expect;

describe('rgbToHexColor(red, green, blue) - returns a color in hexdecimal or undefined', function () {
    describe("Nominal cases (valid input)", function() {
        it("should return #FF9EAA on (255, 158, 170)", function() {
            let expected = '#FF9EAA';
            let actual = rgbToHexColor(255, 158, 170);
            expect(actual).to.be.equal(expected);
        });

        it('should return #000000 on (0, 0, 0)', function () {
            let expected = '#000000';
            let actual = rgbToHexColor(0, 0, 0);
            expect(actual).to.be.equal(expected);
        });

        it('should return #0C0D0E on (12, 13, 14)', function () {
            let expected = '#0C0D0E';
            let actual = rgbToHexColor(12, 13, 14);
            expect(actual).to.be.equal(expected);
        });

        it('should return #FFFFFF on (255, 255, 255)', function () {
            let expected = '#FFFFFF';
            let actual = rgbToHexColor(255, 255, 255);
            expect(actual).to.be.equal(expected);
        });
    });

    describe("Special cases (invalid input)", function() {
        it('should return undefined on (-1, 0, 0)', function () {
            let expected = undefined;
            let actual = rgbToHexColor(-1, 0, 0);
            expect(actual).to.be.equal(expected);
        });

        it('should return undefined on (0, -1, 0)', function () {
            let expected = undefined;
            let actual = rgbToHexColor(0, -1, 0);
            expect(actual).to.be.equal(expected);
        });

        it('should return undefined on (0, 0, -1)', function () {
            let expected = undefined;
            let actual = rgbToHexColor(0, 0, -1);
            expect(actual).to.be.equal(expected);
        });

        it('should return undefined on (256, 0, 0)', function () {
            let expected = undefined;
            let actual = rgbToHexColor(256, 0, 0);
            expect(actual).to.be.equal(expected);
        });

        it('should return undefined on (0, 256, 0)', function () {
            let expected = undefined;
            let actual = rgbToHexColor(0, 256, 0);
            expect(actual).to.be.equal(expected);
        });

        it('should return undefined on (0, 0, 256)', function () {
            let expected = undefined;
            let actual = rgbToHexColor(0, 0, 256);
            expect(actual).to.be.equal(expected);
        });

        it('should return undefined on (3.14, 0, 0)', function () {
            let expected = undefined;
            let actual = rgbToHexColor(3.14, 0, 0);
            expect(actual).to.be.equal(expected);
        });

        it('should return undefined on (0, 3.14, 0)', function () {
            let expected = undefined;
            let actual = rgbToHexColor(0, 3.14, 0);
            expect(actual).to.be.equal(expected);
        });

        it('should return undefined on (0, 0, 3.14)', function () {
            let expected = undefined;
            let actual = rgbToHexColor(0, 0, 3.14);
            expect(actual).to.be.equal(expected);
        });

        it('should return undefined on ("5", [3], {8: 9})', function () {
            let expected = undefined;
            let actual = rgbToHexColor("5", [3], {8: 9});
            expect(actual).to.be.equal(expected);
        });

        it('should return undefined on ()', function () {
            let expected = undefined;
            let actual = rgbToHexColor();
            expect(actual).to.be.equal(expected);
        });
    });
});