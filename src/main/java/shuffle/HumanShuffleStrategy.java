package shuffle;

import models.Card;
import models.Deck;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Nick on 11/6/2016.
 */
public class HumanShuffleStrategy implements ShuffleStrategy {

    /**
     * Human shuffle strategy to cut the deck in half and flip a coin to determin if i take a card from
     * the left or right half.  If we run out of cards in one half then fill the deck with the cards from
     * the other half.  Do this at least 5 times but no more than 15, as a human wouldn't shuffle more
     * than a few times
     * @param deck
     */
    @Override
    public void shuffle(Deck deck) {
        Card[] cards = deck.getCards();

        Random r = new Random();

        for(int i = 0; i < r.nextInt(10) + 5; ++i){
            Card[] half1 = Arrays.copyOfRange(cards, 0, cards.length / 2);
            Card[] half2 = Arrays.copyOfRange(cards, cards.length / 2, cards.length);

            int index1 = 0;
            int index2 = 0;
            for(int j = 0; j < cards.length; ++j){
                if(index1 >= half1.length){
                    cards[j] = half2[index2];
                    ++index2;
                } else if (index2 >= half2.length){
                    cards[j] = half1[index1];
                    ++index1;
                } else if(r.nextInt(2) % 2 == 0){
                    cards[j] = half1[index1];
                    index1++;
                } else {
                    cards[j] = half2[index2];
                    index2++;
                }
            }
        }
    }
}
