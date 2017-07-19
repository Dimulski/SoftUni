let isSymmetric = require('../checkForSymmetry').isSymmetric;
let expect = require('chai').expect;

describe("isSymmetric(arr) - checks whether an array is symmetrical", function() {
    it("should return true for [1, 2, 3, 3, 2, 1]", function () {
        let symmetric = isSymmetric([1, 2, 3, 3, 2, 1]);
        expect(symmetric).to.be.equal(true);
    });

    it("should return false for [1, 2, 3, 4, 2, 1]", function () {
        let expected = false;
        let actual = isSymmetric([1, 2, 3, 4, 2, 1]);
        expect(actual).to.be.equal(expected);
    });

    it("should return true for [-1, 2, -1]", function () {
        let expected = true;
        let actual = isSymmetric([-1, 2, -1]);
        expect(actual).to.be.equal(expected);
    });

    it("should return false for [-1, 2, 1]", function () {
        let expected = false;
        let actual = isSymmetric([-1, 2, 1]);
        expect(actual).to.be.equal(expected);
    });

    it("should return false for [1, 2]", function () {
        let expected = false;
        let actual = isSymmetric([1, 2]);
        expect(actual).to.be.equal(expected);
    });

    it("should return true for [1]", function () {
        let expected = true;
        let actual = isSymmetric([1]);
        expect(actual).to.be.equal(expected);
    });

    it("should return true for [5, 'hi', {a: 5}, new Date(), {a: 5}, 'hi', 5]", function () {
        let expected = true;
        let actual = isSymmetric([5, 'hi', {a: 5}, new Date(), {a: 5}, 'hi', 5]);
        expect(actual).to.be.equal(expected);
    });

    it("should return false for [5, 'hi', {a: 5}, new Date(), {X: 5}, 'hi', 5]", function () {
        let expected = false;
        let actual = isSymmetric([5, 'hi', {a: 5}, new Date(), {X: 5}, 'hi', 5]);
        expect(actual).to.be.equal(expected);
    });

    it("should return false for 1, 2, 2, 1", function () {
        let expected = false;
        let actual = isSymmetric(1, 2, 2, 1);
        expect(actual).to.be.equal(expected);
    });
});
