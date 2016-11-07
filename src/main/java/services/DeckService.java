package services;

import dao.DeckDAO;
import models.Deck;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by Nick on 11/6/2016.
 */
public class DeckService {

    private final DeckDAO dao;

    @Inject
    public DeckService(DeckDAO deckDAO){
        dao = deckDAO;
    }

    public Deck get(String name){
        Deck deck = dao.get(name);
        if(deck == null){
            throw new IllegalArgumentException("Resource not found");
        }
        return deck;
    }

    public void save(Deck deck){
        dao.save(deck);
    }
    public void remove(String name){
        if(!dao.remove(name)){
            throw new IllegalArgumentException("Resource not found");
        }
    }

    public Collection<Deck> getAll(){
        return dao.getAll();
    }

    public void shuffle(String name){
        Deck deck = dao.get(name);
        if(deck == null){
            throw new IllegalArgumentException("Resource not found");
        }
        deck.shuffle();
    }
}
