let mathEnforcer = require('../mathEnforcer').mathEnforcer;
let expect = require('chai').expect;

describe('mathEnforcer - container for 3 methods', function () {
    it('variable should be an object', function () {
        expect(typeof mathEnforcer).to.equal('object');
    });
    it('all object properties should be functions', function () {
        expect(typeof mathEnforcer.addFive).to.equal('function');
        expect(typeof mathEnforcer.subtractTen).to.equal('function');
        expect(typeof mathEnforcer.sum).to.equal('function');
    });

    describe('normal use cases', function () {
        describe('addFive() tests', function () {
            it('should work with integers', function () {
                expect(mathEnforcer.addFive(5)).to.equal(10);
            });
            it('should work with fractions', function () {
                expect(mathEnforcer.addFive(3.5)).to.equal(8.5);
            });
            it('should work with negative values', function () {
                expect(mathEnforcer.addFive(-10)).to.equal(-5);
            });
        });

        describe('subtractTen() tests', function () {
            it('should work with integers', function () {
                expect(mathEnforcer.subtractTen(5)).to.equal(-5);
            });
            it('should work with fractions', function () {
                expect(mathEnforcer.subtractTen(10.5)).to.equal(0.5);
            });
            it('should work with negative values', function () {
                expect(mathEnforcer.subtractTen(-10)).to.equal(-20);
            });
        });

        describe('sum() tests', function () {
            it('should work correctly with integers', function () {
                expect(mathEnforcer.sum(5, 10)).to.equal(15);
            });
            it('should work correctly with fraction', function () {
                expect(mathEnforcer.sum(1.1, 1.01)).to.be.closeTo(2.11, 0.01);
            });
            it('should work correctly with negative values', function () {
                expect(mathEnforcer.sum(5, -10)).to.equal(-5);
            });
            it('should work correctly with negative values', function () {
                expect(mathEnforcer.sum(-5, -10)).to.equal(-15);
            });
            it('should work correctly with zero values', function () {
                expect(mathEnforcer.sum(0, 0)).to.equal(0);
            });
            it("should work correctly with fractions", function () {
                expect(mathEnforcer.sum(5.5, 7)).to.be.equal(12.5);
                expect(mathEnforcer.sum(5, 5.5)).to.be.equal(10.5);
            });
        })
    });

    describe('special cases', function () {
        describe('addFive() tests', function () {
            it('should return undefined for invalid parameter', function () {
                expect(mathEnforcer.addFive('invalid')).to.equal(undefined);
            });
            it('should return undefined if no parameters are given', function () {
                expect(mathEnforcer.addFive()).to.equal(undefined);
            });
        });

        describe('subtractTen() tests', function () {
            it('should return undefined for invalid parameter', function () {
                expect(mathEnforcer.subtractTen('invalid')).to.equal(undefined);
            });
            it('should return undefined if no parameters are given', function () {
                expect(mathEnforcer.subtractTen()).to.equal(undefined);
            });
        });

        describe('sum() tests', function () {
            it('should return undefined for invalid parameter', function () {
                expect(mathEnforcer.sum('invalid', 'invalid')).to.equal(undefined);
            });
            it('should return undefined if no parameters are given', function () {
                expect(mathEnforcer.sum()).to.equal(undefined);
            });
            it('should return undefined for invalid first parameter', function () {
                expect(mathEnforcer.sum('invalid', 10)).to.equal(undefined);
            });
            it('should return undefined for invalid second parameter', function () {
                expect(mathEnforcer.sum(10, 'invalid')).to.equal(undefined);
            });
        })
    });
});