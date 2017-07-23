let SortedList = require('../sortedList').SortedList;
let expect = require('chai').expect;

describe('SortedList Unit Tests', function () {
    let myList;
    beforeEach(function () {
        myList = new SortedList();
    });

    describe('Test initial test', function () {
        it('add exists', function () {
            expect(SortedList.prototype.hasOwnProperty('add')).to.equal(true);
        });
        it('remove exists', function () {
            expect(SortedList.prototype.hasOwnProperty('remove')).to.equal(true);
        });
        it('get exists', function () {
            expect(SortedList.prototype.hasOwnProperty('get')).to.equal(true);
        });
        it('size exists', function () {
            expect(SortedList.prototype.hasOwnProperty('size')).to.equal(true);
        });
    });

    describe('Test add', function () {
        it('with one element', function () {
            myList.add(5);
            expect(myList.list.join(', ')).to.equal('5');
        });
        it('with many elements', function () {
            myList.add(5);
            myList.add(3);
            myList.add(4);
            myList.add(7);
            expect(myList.list.join(', ')).to.equal('3, 4, 5, 7');
        });
    });

    describe('Test remove', function () {
        it('with empty list', function () {
            expect(() => myList.remove()).throw(Error, 'Collection is empty.')
        });
        it('with negative index', function () {
            myList.add(3);
            expect(() => myList.remove(-1)).throw(Error, 'Index was outside the bounds of the collection.')
        });
        it('with index bigger than list length', function () {
            myList.add(3);
            expect(() => myList.remove(2)).throw(Error, 'Index was outside the bounds of the collection.')
        });
        it('with correct index (should remove)', function () {
            myList.add(3);
            myList.add(4);
            myList.add(5);
            myList.remove(1);
            expect(myList.list.join(', ')).to.equal('3, 5');
        })
    });
    describe('Test get', function () {
        it('with empty list', function () {
            expect(() => myList.get()).throw(Error, 'Collection is empty.')
        });
        it('with negative index', function () {
            myList.add(3);
            expect(() => myList.get(-1)).throw(Error, 'Index was outside the bounds of the collection.')
        });
        it('with index bigger than list length', function () {
            myList.add(3);
            expect(() => myList.get(2)).throw(Error, 'Index was outside the bounds of the collection.')
        });
        it('with correct index (should remove)', function () {
            myList.add(3);
            myList.add(5);
            myList.add(4);
            let element = myList.get(1);
            expect(element).to.be.equal(4);
        });
    });

    describe('Test size', function () {
        it('with empty list', function () {
            expect(myList.size).to.be.equal(0);
        });
        it('with non-empty list', function () {
            myList.add(1);
            myList.add(2);
            myList.add(3);
            expect(myList.size).to.be.equal(3);
        })
    })
});