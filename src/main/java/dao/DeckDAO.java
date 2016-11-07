package dao;

import models.Deck;

import java.util.Collection;

/**
 * Created by Nick on 11/6/2016.
 */
public interface DeckDAO {
    Deck get(String name);
    void save(Deck deck);
    boolean remove(String name);
    Collection<Deck> getAll();
}
