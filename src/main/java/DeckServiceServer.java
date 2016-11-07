import com.google.common.base.Preconditions;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.ServletModule;
import com.squarespace.jersey2.guice.JerseyGuiceModule;
import com.squarespace.jersey2.guice.JerseyGuiceUtils;
import inject.DeckModule;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import resources.DeckResource;
import util.StringConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 11/6/2016.
 */
public class DeckServiceServer {
    public static void main(String[] args) throws Exception {
        Preconditions.checkArgument(validateArgs(args), printHelp());
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath("/");

        Server server = new Server(8080);
        server.setHandler(contextHandler);

        ServletHolder servletHolder = contextHandler.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "/*"
        );
        servletHolder.setInitOrder(0);

        servletHolder.setInitParameter(
                "jersey.config.server.provider.classnames", DeckResource.class.getCanonicalName()
        );

        List<Module> modules = new ArrayList<>();
        modules.add(new JerseyGuiceModule("__HK2_Generated_0"));
        modules.add(new ServletModule());
        modules.add(new DeckModule(args[0]));

        Injector injector = Guice.createInjector(modules);
        JerseyGuiceUtils.install(injector);

        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }
    }

    private static boolean validateArgs(String[] args) {
        return args != null
                && args.length == 1
                && (StringConstants.BASIC_SHUFFLE_STRATEGY.equals(args[0])
                || StringConstants.HUMAN_SHUFFLE_STRATEGY.equals(args[0]));
    }

    private static String printHelp() {
        return "Deck service requires a parameter to decide shuffle strategy for all decks.  Must be one of the following:\n"
                + StringConstants.BASIC_SHUFFLE_STRATEGY + "\n"
                + StringConstants.HUMAN_SHUFFLE_STRATEGY + "\n";
    }
}
