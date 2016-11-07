package inject;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import dao.DeckDAO;
import dao.InMemoryDeckDAO;
import services.DeckService;
import shuffle.BasicShuffleStrategy;
import shuffle.HumanShuffleStrategy;
import shuffle.ShuffleStrategy;
import util.StringConstants;

/**
 * Created by Nick on 11/6/2016.
 */
public class DeckModule extends AbstractModule {
    private final String shuffleStrategy;
    public DeckModule(String shuffleStrategy) {
        this.shuffleStrategy = shuffleStrategy;
    }

    @Override
    protected void configure() {
        bind(DeckDAO.class).to(InMemoryDeckDAO.class).asEagerSingleton();
        bind(DeckService.class);
    }

    @Provides
    public ShuffleStrategy shuffleStrategy(){
        switch(shuffleStrategy){
            case StringConstants.BASIC_SHUFFLE_STRATEGY:
                return new BasicShuffleStrategy();
            case StringConstants.HUMAN_SHUFFLE_STRATEGY:
                return new HumanShuffleStrategy();
            default:
                throw new IllegalArgumentException("Strategy not defined");
        }
    }
}
