let expect = require('chai').expect;
let Console = require('../CSharpConsole').Console;

describe("Test Console class functionality", function () {
    describe("Test if method exists", function () {
        it("Should be of type function", function () {
            expect(typeof(Console.writeLine)).to.equal('function');
        });
    });
    describe("Test when only one argument is passed", function () {
        it("Should return it when only single string parameter is passed", function () {
            expect(Console.writeLine('Test string')).to.equal('Test string');
        });
        it("Should throw RangeError when placeholders are not valid", function () {
            expect(Console.writeLine('Test {0}, it should not throw error')).to.equal('Test {0}, it should not throw error');
        });
        it("Should return it when only single string parameter is passed", function () {
            expect(Console.writeLine('')).to.equal('');
        });
        it("Should return stringified object when only object is passed", function () {
            let obj = {test: 'test', otherProp: 123, someElse: [3, 'test', {prop: 'try it'}]};
            expect(Console.writeLine(obj)).to.equal(JSON.stringify(obj));
        });
    });
    describe("Test when more than one arguments are passed", function () {
        describe("Test when the first argument is not a string", function () {
            it("Should throw TypeError when the first argument is object", function () {
                expect(function(){Console.writeLine({test:'test'}, "hello")}).to.throw(TypeError);
            });
            it("Should throw TypeError when the first argument is number", function () {
                expect(function(){Console.writeLine(12345, "hello")}).to.throw(TypeError);
            });
            it("Should throw TypeError when the first argument is array", function () {
                expect(function(){Console.writeLine([1,2,3,4,5], "hello")}).to.throw(TypeError);
            });
        });
        describe("Test when not enough arguments for the placeholders are passed", function () {
            it("Should throw RangeError then there are 3 placeholders and only two arguments passed", function () {
                expect(()=>Console.writeLine('Test {0}, it should {1} {2}', 'that')).to.throw(RangeError);
            });
            it("Should throw RangeError then there are 3 placeholders and four arguments passed", function () {
                expect(()=>Console.writeLine('Test {0}, it should {1} {2}', 'that', 'throw', 'error', 'not needed argument')).to.throw(RangeError);
            });
            it("Should throw RangeError when placeholders are not valid", function () {
                expect(()=>Console.writeLine('Test {0}, it should {1} {20}', 'that', 'throw', 'error')).to.throw(RangeError);
            });
            it("Should throw RangeError when placeholders are not valid", function () {
                expect(()=>Console.writeLine('Test {0}, it should {1} {2} {3} {4}, {13}', 'that', 'throw', 'error', 'not needed argument')).to.throw(RangeError);
            });
            it("Should throw RangeError when placeholders are not valid", function () {
                expect(()=>Console.writeLine('Test {0}, it should {1} {2} {3}, {13}', 'that', 'throw', 'error', 'not needed argument')).to.throw(RangeError);
            });
            it("Should throw RangeError when placeholders are not valid", function () {
                expect(()=>Console.writeLine('Test {0}, it should {-1} {2}', 'that', 'throw', 'error')).to.throw(RangeError);
            });

        });
        describe("Test when all parameters are valid", function () {
            it("Should throw RangeError then there are 3 placeholders and only two arguments passed", function () {
                expect(Console.writeLine('Test {0}, it should not {1} {2}', 'that', 'throw', 'error')).to.equal('Test that, it should not throw error');
            });
            it("Should throw RangeError then there are 3 placeholders and only two arguments passed", function () {
                expect(Console.writeLine('Test {0}, it should not {1} {2}', 'that', 'throw', 'error')).to.equal('Test that, it should not throw error');
            });
        })
    });
});