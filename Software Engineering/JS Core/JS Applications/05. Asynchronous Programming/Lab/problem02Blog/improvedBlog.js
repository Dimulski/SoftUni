function attachEvents() {
    const baseUrl = 'https://baas.kinvey.com/appdata/kid_BJiqeB1uZ/';
    const username = 'pesho';
    const password =  'pass123';

    const select = $('#posts');
    const postComments = $('#post-comments');
    const postTitle = $('#post-title');
    const postBody = $('#post-body');

    select.on('change', viewPost);

    loadPosts();

    function request(endpoint) {
        return $.ajax({
            url: baseUrl + endpoint,
            headers: {
                'Authorization': 'Basic ' + btoa(`${username}:${password}`)
            }
        })
    }

    async function loadPosts() {
        select.empty();
        select.append($('<option>Loading...</option>'));
        select.prop('disabled', true);
        try {
            let data = await request('posts');
            select.empty();
            for (let post of data) {
                $('<option>')
                    .text(post.title)
                    .val(post._id)
                    .appendTo(select);
            }
            if (data.length !== 0) {
                viewPost();
            }
        } catch (reason) {
            handleError(reason);
        } finally {
            select.prop('disabled', false)
        }
    }

    async function viewPost() {
        select.prop('disabled', true);
        postTitle.empty();
        postTitle.append('<span>Loading...</span>');
        let postId = select.find('option:selected').val();
        let postP = request('posts/' + postId);
        let commentsP = request(`comments/?query={"post_id":"${postId}"}`);
        try {
            let [data, comments] = await Promise.all([postP, commentsP]);
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
        } catch (reason) {
            handleError(reason)
        } finally {
            select.prop('disabled', false);
        }
    }

    function handleError(reason) {
        console.warn(reason);
    }
}