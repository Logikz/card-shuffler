package models;

/**
 * Created by Nick on 11/6/2016.
 */
public class Card {
    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public enum Value{
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }

    public enum Suit {
        HEARTS,
        CLUBS,
        DIAMONDS,
        SPADES
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Card card = (Card) o;

        return suit == card.suit && value == card.value;
    }

    @Override
    public int hashCode() {
        int result = suit.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
