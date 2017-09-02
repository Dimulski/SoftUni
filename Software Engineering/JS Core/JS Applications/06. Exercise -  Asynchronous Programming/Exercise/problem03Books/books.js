function attachEvents() {
    const username = "pesho";
    const password = "pass123";
    const authHeader = {
        'Authorization': 'Basic ' + btoa(`${username}:${password}`),
        'Content-type': 'application/json'
    };
    $(listAllBooks());
    $('.add').click(addBook);

    async function listAllBooks() {
        let books = await $.ajax({
            url: 'https://baas.kinvey.com/appdata/kid_HJYYS9Ndb/books',
            headers: authHeader
        });
        let bookContainer = $('#books');
        bookContainer.empty();
        for (let book of books) {
            $(`<div class="book" data-id="${book._id}">`)
                .append($('<label>Title</label>'))
                .append($(`<input type="text" class="title" value="${book.title}"/>`))
                .append($('<label>Author</label>'))
                .append($(`<input type="text" class="author" value="${book.author}"/>`))
                .append($('<label>ISBN</label>'))
                .append($(`<input type="text" class="isbn" value="${book.isbn}"/>`))
                .append($('<button class="update">Update</button>').click(updateBook))
                .append($('<button class="delete">Delete</button>').click(deleteBook))
                .appendTo(bookContainer);
        }
    }

    async function updateBook() {
        let bookElement = $(this).parent();
        let bookJSON = createDataJSON(bookElement);
        $.ajax({
            method: 'PUT',
            url: `https://baas.kinvey.com/appdata/kid_HJYYS9Ndb/books/${bookElement.attr('data-id')}`,
            headers: authHeader,
            data: JSON.stringify(bookJSON)
        });
    }

    async function deleteBook() {
        let bookElement = $(this).parent();
        $.ajax({
            method: 'DELETE',
            url: `https://baas.kinvey.com/appdata/kid_HJYYS9Ndb/books/${bookElement.attr('data-id')}`,
            headers: authHeader,
            complete: bookElement.remove()
        })
    }

    function addBook() {
        let bookElement = $('#addForm');
        let dataObj = createDataJSON(bookElement);
        $.ajax({
            method: "POST",
            url: 'https://baas.kinvey.com/appdata/kid_HJYYS9Ndb/books',
            headers: authHeader,
            data: JSON.stringify(dataObj),
            complete: listAllBooks()
        })
    }

    function createDataJSON(bookElement) {
        return {
            title: bookElement.find('.title').val(),
            author: bookElement.find('.author').val(),
            isbn: bookElement.find('.isbn').val(),
        };
    }

    function handleError(error) {
        console.warn(error);
    }
}