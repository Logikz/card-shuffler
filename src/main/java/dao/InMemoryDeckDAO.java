package dao;

import models.Deck;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nick on 11/6/2016.
 */
public class InMemoryDeckDAO implements DeckDAO {
    private Map<String, Deck> decks = new HashMap<>();

    @Override
    public Deck get(String name) {
        return decks.get(name);
    }

    @Override
    public void save(Deck deck) {
        decks.put(deck.getName(), deck);
    }

    @Override
    public boolean remove(String name) {
        Deck deck = decks.remove(name);
        return deck != null;
    }

    @Override
    public Collection<Deck> getAll() {
        return decks.values();
    }
}
