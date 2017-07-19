let expect = require('chai').expect;
let jsdom = require('jsdom-global')();
let $ = require('jquery');

let nuke = function nuke(selector1, selector2) {
    if (selector1 === selector2) return;
    $(selector1).filter(selector2).remove();
};

describe('nuke(selector1, selector2) - removes an element that matches both selectors', function () {
    let targetHTML;
    beforeEach(function () {
        document.body.innerHTML = `
    <body>
    <div id="target">
        <div class="nested target">
            <p>This is some text</p>
        </div>
        <div class="target">
            <p>Empty div</p>
        </div>
        <div class="inside">
            <span class="nested">Some more text</span>
            <span class="target">Some more text</span>
        </div>
    </div>
    </body>`;
        targetHTML = $('#target');
    });

    it('should work correctly with correct selector', function () {
        let selector1 = $('.nested');
        let selector2 = $('.target');
        let oldValue = targetHTML.html();
        nuke(selector1, selector2);
        expect(targetHTML.html()).to.not.equal(oldValue);
    });
    it('should work correctly with invalid selector', function () {
        let selector1 = $('.nested');
        let selector2 = 'invalid';
        let oldHTML = selector1.html();
        nuke(selector1, selector2);
        expect(selector1.html()).to.be.equal(oldHTML);
    });
    it('should work correctly with equal selector', function () {
        let selector1 = $('.inside');
        let oldHTML = targetHTML.html();
        nuke(selector1, selector1);
        expect(targetHTML.html()).to.be.equal(oldHTML);
    });
    it('should work correctly with valid selectors which do not match anything', function () {
        let selector1 = $('.nested');
        let selector2 = $('.inside');
        let oldValue = targetHTML.html();
        nuke(selector1, selector2);
        expect(targetHTML.html()).to.be.equal(oldValue);
    });
});
