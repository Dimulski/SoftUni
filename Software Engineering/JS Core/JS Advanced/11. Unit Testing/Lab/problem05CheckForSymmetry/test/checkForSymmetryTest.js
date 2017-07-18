let isSymmetric = require('../checkForSymmetry').isSymmetric;
let expect = require('chai').expect;

describe("isSymmetric(arr) - checks whether an array is symmetrical", function() {
    describe('General tests', function () {
        it("should return true for [1, 2, 3, 3, 2, 1]", function () {
            let symmetric = isSymmetric([1, 2, 3, 3, 2, 1]);
            expect(symmetric).to.be.equal(true);
        });

        it("should return false for [1, 2, 3, 4, 2, 1]", function () {
            let expected = false;
            let actual = isSymmetric([1, 2])
        });

        it("should return true for [-1, 2, -1]", function () {

        });

        it("should return false for [-1, 2, 1]", function () {

        });
    });
});
