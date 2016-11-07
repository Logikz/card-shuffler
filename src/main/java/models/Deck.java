package models;

import shuffle.ShuffleStrategy;
import util.DeckUtil;

/**
 * Created by Nick on 11/6/2016.
 */
public class Deck {
    private String name;
    private Card[] cards;
    private ShuffleStrategy shuffleStrategy;

    public Deck(String name, ShuffleStrategy shuffleStrategy) {
        this.name = name;
        this.shuffleStrategy = shuffleStrategy;
        cards = DeckUtil.basicDeck();
    }

    public void shuffle(){
        shuffleStrategy.shuffle(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }
}
