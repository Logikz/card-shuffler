package util;

import models.Card;

/**
 * Created by Nick on 11/6/2016.
 */
public class DeckUtil {
    public static Card[] basicDeck() {
        return new Card[]{
                new Card(Card.Suit.CLUBS, Card.Value.ACE),
                new Card(Card.Suit.CLUBS, Card.Value.TWO),
                new Card(Card.Suit.CLUBS, Card.Value.THREE),
                new Card(Card.Suit.CLUBS, Card.Value.FOUR),
                new Card(Card.Suit.CLUBS, Card.Value.FIVE),
                new Card(Card.Suit.CLUBS, Card.Value.SIX),
                new Card(Card.Suit.CLUBS, Card.Value.SEVEN),
                new Card(Card.Suit.CLUBS, Card.Value.EIGHT),
                new Card(Card.Suit.CLUBS, Card.Value.NINE),
                new Card(Card.Suit.CLUBS, Card.Value.TEN),
                new Card(Card.Suit.CLUBS, Card.Value.JACK),
                new Card(Card.Suit.CLUBS, Card.Value.QUEEN),
                new Card(Card.Suit.CLUBS, Card.Value.KING),

                new Card(Card.Suit.HEARTS, Card.Value.ACE),
                new Card(Card.Suit.HEARTS, Card.Value.TWO),
                new Card(Card.Suit.HEARTS, Card.Value.THREE),
                new Card(Card.Suit.HEARTS, Card.Value.FOUR),
                new Card(Card.Suit.HEARTS, Card.Value.FIVE),
                new Card(Card.Suit.HEARTS, Card.Value.SIX),
                new Card(Card.Suit.HEARTS, Card.Value.SEVEN),
                new Card(Card.Suit.HEARTS, Card.Value.EIGHT),
                new Card(Card.Suit.HEARTS, Card.Value.NINE),
                new Card(Card.Suit.HEARTS, Card.Value.TEN),
                new Card(Card.Suit.HEARTS, Card.Value.JACK),
                new Card(Card.Suit.HEARTS, Card.Value.QUEEN),
                new Card(Card.Suit.HEARTS, Card.Value.KING),

                new Card(Card.Suit.SPADES, Card.Value.ACE),
                new Card(Card.Suit.SPADES, Card.Value.TWO),
                new Card(Card.Suit.SPADES, Card.Value.THREE),
                new Card(Card.Suit.SPADES, Card.Value.FOUR),
                new Card(Card.Suit.SPADES, Card.Value.FIVE),
                new Card(Card.Suit.SPADES, Card.Value.SIX),
                new Card(Card.Suit.SPADES, Card.Value.SEVEN),
                new Card(Card.Suit.SPADES, Card.Value.EIGHT),
                new Card(Card.Suit.SPADES, Card.Value.NINE),
                new Card(Card.Suit.SPADES, Card.Value.TEN),
                new Card(Card.Suit.SPADES, Card.Value.JACK),
                new Card(Card.Suit.SPADES, Card.Value.QUEEN),
                new Card(Card.Suit.SPADES, Card.Value.KING),

                new Card(Card.Suit.DIAMONDS, Card.Value.ACE),
                new Card(Card.Suit.DIAMONDS, Card.Value.TWO),
                new Card(Card.Suit.DIAMONDS, Card.Value.THREE),
                new Card(Card.Suit.DIAMONDS, Card.Value.FOUR),
                new Card(Card.Suit.DIAMONDS, Card.Value.FIVE),
                new Card(Card.Suit.DIAMONDS, Card.Value.SIX),
                new Card(Card.Suit.DIAMONDS, Card.Value.SEVEN),
                new Card(Card.Suit.DIAMONDS, Card.Value.EIGHT),
                new Card(Card.Suit.DIAMONDS, Card.Value.NINE),
                new Card(Card.Suit.DIAMONDS, Card.Value.TEN),
                new Card(Card.Suit.DIAMONDS, Card.Value.JACK),
                new Card(Card.Suit.DIAMONDS, Card.Value.QUEEN),
                new Card(Card.Suit.DIAMONDS, Card.Value.KING)};
    }
}
