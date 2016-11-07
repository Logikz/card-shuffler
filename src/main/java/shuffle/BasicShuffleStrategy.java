package shuffle;

import models.Card;
import models.Deck;

import java.util.Random;

/**
 * Created by Nick on 11/6/2016.
 */
public class BasicShuffleStrategy implements ShuffleStrategy {
    public void shuffle(Deck deck) {
        Card[] cards = deck.getCards();

        Random random = new Random();
        for (int i = 0; i < 1000; ++i) {
            int firstIndex = random.nextInt(cards.length);
            int secondIndex = random.nextInt(cards.length);
            Card temp = cards[firstIndex];
            cards[firstIndex] = cards[secondIndex];
            cards[secondIndex] = temp;
        }
    }
}
