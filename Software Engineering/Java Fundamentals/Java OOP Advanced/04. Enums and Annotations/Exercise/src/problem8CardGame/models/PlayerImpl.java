package problem8CardGame.models;

import problem8CardGame.contracts.Card;
import problem8CardGame.contracts.Player;

import java.util.List;

public class PlayerImpl implements Player {

    private String name;
    private List<Card> hand;

    public PlayerImpl(String name, List<Card> hand) {
        this.setName(name);
        this.setHand(hand);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Card> getHand() {
        return this.hand;
    }

    private void setHand(List<Card> hand) {
        this.hand = hand;
    }
}
