let post = {
    id: '3',
    author: 'emil',
    content: 'wazaaaaa',
    upvotes: 100,
    downvotes: 100
};

function solution(command) {
    switch (command) {
        case 'upvote':
            this.upvotes++;
            break;
        case 'downvote':
            this.downvotes++;
            break;
        case 'score':
            let upvotes = this.upvotes;
            let downvotes = this.downvotes;
            let rank = 'new';
            let totalVotes = upvotes + downvotes;

            if (upvotes + downvotes >= 10) {
                if (upvotes > 0.66 * totalVotes) {
                    rank = 'hot';
                } else if (downvotes > upvotes) {
                    rank = 'unpopular';
                } else if ((upvotes - downvotes > 0) && upvotes > 100 || downvotes > 100) {
                    rank = 'controversial';
                }
            }

            if (totalVotes > 50) {
                let addition = Math.ceil(0.25 * Math.max(upvotes, downvotes));
                upvotes += addition;
                downvotes += addition;
            }

            let voteDifference = upvotes - downvotes;

            return [upvotes, downvotes, voteDifference, rank];
    }
}

solution.call(post, 'upvote');
console.log(solution.call(post, 'score'));