function printDeckOfCards(cards) {
    let deck = [];
    for (let cardStr of cards) {
        let cardFace = cardStr.substring(0, cardStr.length - 1);
        let cardSuit = cardStr.substr(cardStr.length - 1, 1);
        try {
            deck.push(makeCard(cardFace, cardSuit));
        } catch (ex) {
            console.log('Invalid card: ' + cardStr);
            return;
        }
    }
    console.log(deck.join(' '));

    function makeCard(face, suit) {
        const validFaces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
        const validSuits = ['S', 'H', 'D', 'C'];
        if (!validFaces.includes(face)) {
            throw new Error('Invalid card face: ' + face);
        }
        if (!validSuits.includes(suit)) {
            throw new Error('Invalid card suit: ' + suit);
        }

        let card = {
            face: face,
            suit: suit,
            toString: () => {
                let suitToChar = {
                    'S': "\u2660", // ♠
                    'H': "\u2665", // ♥
                    'D': "\u2666", // ♦
                    'C': "\u2663", // ♣
                };
                return card.face + suitToChar[card.suit];
            }
        };

        return card;
    }
}

printDeckOfCards(['AS', '10D', 'KH', '2C']);
printDeckOfCards(['5S', '3D', 'QD', '1C']);
