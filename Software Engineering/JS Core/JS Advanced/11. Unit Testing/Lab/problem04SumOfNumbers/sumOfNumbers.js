function sum(arr) {
    let sum = 0;
    for (num of arr)
        sum += Number(num);
    return sum;
}

let expect = require('chai').expect;

describe('sum(arr) - sum array of numbers', function () {
    it('should return 3 for [1, 2]', function () {
        expect(sum([1, 2])).to.equal(3);
    });

    it('should return 1 for [1]', function () {
        expect(sum([1])).to.be.equal(1);
    });

    it('should return 0 for empty array', function () {
        let expected = 0;
        let actual = sum([]);
        expect(actual).to.be.equal(expected);
    });

    it('should return 3 for [1.5, 2.5, -1]', function () {
        let expected = 3;
        let actual = sum([1.5, 2.5, -1]);
        expect(actual).to.be.equal(expected);
    });

    it('should return NaN for invalid data', function () {
        expect(sum(['pesho', 2, 3])).to.be.NaN;
    });
});