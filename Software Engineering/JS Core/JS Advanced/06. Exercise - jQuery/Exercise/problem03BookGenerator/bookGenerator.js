function createBook(selector, title, author, isbn) {
    let bookGenerator = (function () {
        let id = 1;
        return function (selector, title, author, isbn) {
            let container = $(selector);
            let divElement = $('<div>');
            divElement.attr(`book${id}`);
            divElement.css('border', 'none');
            let titleElement = $(`<p class="title">${title}</p>`);
            let authorElement = $(`<p class="author">${author}</p>`);
            let isbnElement = $(`<p class="isbn">${isbn}</p>`);
            let selectBtn = $('<button>Select</button>');
            selectBtn.on('click', function () {
                divElement.css('border', '2px solid blue');
            });
            let deselectBtn = $('<button>Deselect</button>');
            deselectBtn.on('click', function () {
                divElement.css('border', 'none');
            });
            titleElement.appendTo(divElement);
            authorElement.appendTo(divElement);
            isbnElement.appendTo(divElement);
            selectBtn.appendTo(divElement);
            deselectBtn.appendTo(divElement);
            divElement.appendTo(container);
            id++;
        }
    }());
    bookGenerator(selector, title, author, isbn);
}