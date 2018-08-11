package it.unibo.goffo.fag.score.controller.format;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import it.unibo.goffo.fag.score.Score;

import java.lang.reflect.Type;
import java.util.Collection;

/**
 * This class use JSON for serialize object.
 */
public class JsonFormatter implements Format<String> {

    private final Gson gson;

    /**
     * Default constructor.
     */
    public JsonFormatter() {
        gson = new Gson();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String formatter(final Collection<? extends Score> collection) {
        return gson.toJson(collection);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<? extends Score> restore(final String formatted) {
        final Type collectionType = new TypeToken<Collection<Score>>() { }.getType();
        return gson.fromJson(formatted, collectionType);
    }
}
