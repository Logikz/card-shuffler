package resources;

import models.Deck;
import services.DeckService;
import shuffle.ShuffleStrategy;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * Created by Nick on 11/6/2016.
 */
@Path("/api/deck")
public class DeckResource {

    private final DeckService deckService;
    private final ShuffleStrategy shuffleStrategy;

    @Inject
    public DeckResource(DeckService deckService, ShuffleStrategy shuffleStrategy) {
        this.deckService = deckService;
        this.shuffleStrategy = shuffleStrategy;
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeck(@PathParam("name") String name) {
        Deck deck;
        try {
            deck = deckService.get(name);
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(deck).build();
    }

    @PUT
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addDeck(@PathParam("name") String name) {
        Deck deck = new Deck(name, shuffleStrategy);
        deckService.save(deck);

        return Response.ok(deck).build();
    }

    @POST
    @Path("/{name}")
    public Response shuffleDeck(@PathParam("name") String name) {
        try {
            deckService.shuffle(name);
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok().build();
    }

    @DELETE
    @Path("/{name}")
    public Response removeDeck(@PathParam("name") String name) {
        try {
            deckService.remove(name);
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Collection<Deck> decks = deckService.getAll();

        return Response.ok(decks).build();
    }
}
