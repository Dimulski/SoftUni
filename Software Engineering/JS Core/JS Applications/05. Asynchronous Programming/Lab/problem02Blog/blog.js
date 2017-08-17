function attachEvents() {
    const baseUrl = 'https://baas.kinvey.com/appdata/kid_BJiqeB1uZ/';
    const username = 'pesho';
    const password =  'pass123';

    $('#btnLoadPosts').click(loadPosts);
    $('#btnViewPost').click(viewPost);

    const select = $('#posts');
    const postComments = $('#post-comments');
    const postTitle = $('#post-title');
    const postBody = $('#post-body');

    function request(endpoint) {
        return $.ajax({
            url: baseUrl + endpoint,
            headers: {
                'Authorization': 'Basic ' + btoa(`${username}:${password}`)
            }
        })
    }

    function loadPosts() {
        request('posts')
            .then(fillSelect)
            .catch(handleError);

        function fillSelect(data) {
            select.empty();
            for (let post of data) {
                $('<option>')
                    .text(post.title)
                    .val(post._id)
                    .appendTo(select);
            }
        }
    }

    function viewPost() {
        let postId = select.find('option:selected').val();
        let postP = request('posts/' + postId);
        let commentsP = request(`comments/?query={"post_id":"${postId}"}`);
        Promise.all([postP, commentsP])
            .then(displayPostAndComments)
            .catch(handleError);

        function displayPostAndComments([data, comments]) {
            postTitle.empty();
            postBody.empty();
            postTitle.text(data.title);
            postBody.text(data.body);
            postComments.empty();
            for (let comment of comments) {
                postComments.append($(`<li>${comment.text}</li>`));
            }
            if (comments.length === 0) {
                postComments.append($('<li>No comments yet</li>'));
            }
        }
    }

    function handleError(reason) {
        console.warn(reason);
    }
}