package services;

import dao.DeckDAO;
import models.Deck;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import shuffle.ShuffleStrategy;

import static junit.framework.TestCase.assertSame;
import static junit.framework.TestCase.fail;
import static org.mockito.Mockito.times;

/**
 * Created by Nick on 11/6/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class DeckServiceTest {
    private DeckService deckService;

    @Mock
    private DeckDAO deckDAO;

    @Mock
    private ShuffleStrategy strategy;

    @Before
    public void init(){
        deckService = new DeckService(deckDAO);
    }

    @Test
    public void getDeckTest(){
        Deck deck = new Deck("test", strategy);

        Mockito.when(deckDAO.get("test")).thenReturn(deck);
        deckService.get("test");
        Mockito.verify(deckDAO).get("test");
        Mockito.verify(strategy, times(0)).shuffle(deck);
    }

    @Test
    public void getDeckNotFoundTest(){
        Mockito.when(deckDAO.get("test")).thenReturn(null);
        try{
            deckService.get("test");
            fail();
        } catch (IllegalArgumentException e){
            assertSame(e.getMessage(), "Resource not found");
        }
        Mockito.verify(deckDAO).get("test");
    }

    @Test
    public void removeDeckTest(){
        Mockito.when(deckDAO.remove("test")).thenReturn(true);
        deckService.remove("test");
        Mockito.verify(deckDAO).remove("test");
    }

    @Test
    public void removeDeckNotFoundTest(){
        Mockito.when(deckDAO.remove("test")).thenReturn(false);
        try{
            deckService.remove("test");
            fail();
        } catch (IllegalArgumentException e){
            assertSame(e.getMessage(), "Resource not found");
        }
        Mockito.verify(deckDAO).remove("test");
    }

    @Test
    public void shuffleDeckTest(){
        Deck deck = new Deck("test", strategy);

        Mockito.when(deckDAO.get("test")).thenReturn(deck);
        deckService.shuffle("test");
        Mockito.verify(deckDAO).get("test");
        Mockito.verify(strategy).shuffle(deck);
    }

    @Test
    public void shuffleDeckNotFoundTest(){
        Mockito.when(deckDAO.get("test")).thenReturn(null);
        try{
            deckService.shuffle("test");
            fail();
        } catch (IllegalArgumentException e){
            assertSame(e.getMessage(), "Resource not found");
        }
        Mockito.verify(deckDAO).get("test");
    }
}
