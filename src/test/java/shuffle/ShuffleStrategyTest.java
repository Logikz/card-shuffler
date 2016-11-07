package shuffle;

import models.Card;
import models.Deck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import util.DeckUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Nick on 11/6/2016.
 */
@RunWith(JUnit4.class)
public class ShuffleStrategyTest {

    @Test
    public void basicShuffleTest() {
        Deck deck = new Deck("test", new BasicShuffleStrategy());
        assert (checkDecks(deck.getCards(), DeckUtil.basicDeck()));

        deck.shuffle();

        assertFalse(checkDecks(deck.getCards(), DeckUtil.basicDeck()));
    }

    @Test
    public void humanShuffleTest(){
        Deck deck = new Deck("test", new HumanShuffleStrategy());
        assert(checkDecks(deck.getCards(), DeckUtil.basicDeck()));

        deck.shuffle();

        assertFalse(checkDecks(deck.getCards(), DeckUtil.basicDeck()));
    }

    private boolean checkDecks(Card[] deck1, Card[] deck2) {
        if (deck1 == null || deck2 == null || deck1.length != deck2.length) {
            return false;
        }
        Set<Card> uniqueDeck1 = new HashSet<>();
        Set<Card> uniqueDeck2 = new HashSet<>();

        for (int i = 0; i < deck1.length; i++) {
            if (!deck1[i].equals(deck2[i])) {
                return false;
            }
            if (!(uniqueDeck1.add(deck1[i]) && uniqueDeck2.add(deck2[i]))) {
                return false;
            }
        }
        return true;
    }
}
