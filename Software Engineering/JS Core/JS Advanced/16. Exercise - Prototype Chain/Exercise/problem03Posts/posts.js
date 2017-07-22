function solve() {
    class Post {
        constructor(title, content) {
            this.title = title;
            this.content = content;
        }

        get title() {
            return this._title;
        }

        set title(title) {
            this._title = title;
        }

        get content() {
            return this._content;
        }

        set content(content) {
            this._content = content;
        }

        toString() {
            return `Post: ${this.title}\nContent: ${this.content}`;
        }
    }

    class SocialMediaPost extends Post {
        constructor(title, content, likes, dislikes) {
            super(title, content);
            this._likes = likes;
            this._dislikes = dislikes;
            this._comments = [];
        }

        addComment(comment) {
            this._comments.push(comment);
        }

        toString() {
            let rating = this._likes - this._dislikes;
            let result = [];
            result.push(`${super.toString()}\nRating: ${rating}`);
            if (this._comments.length !== 0) {
                result.push('\nComments:');
                for (let comment of this._comments) {
                    result.push(`\n * ${comment}`);
                }
            }
            return result.join('');
        }
    }

    class BlogPost extends Post {
        constructor(title, content, views) {
            super(title, content);
            this._views = views;
        }

        view() {
            this._views++;
            return this;
        }

        toString() {
            return `${super.toString()}\nViews: ${this._views}`;
        }
    }

    return {
        Post,
        SocialMediaPost,
        BlogPost
    }
}