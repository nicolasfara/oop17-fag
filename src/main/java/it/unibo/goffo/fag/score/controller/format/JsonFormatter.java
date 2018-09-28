package it.unibo.goffo.fag.score.controller.format;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;
import it.unibo.goffo.fag.score.JsonScore;
import it.unibo.goffo.fag.score.Score;

import java.lang.reflect.Type;
import java.util.List;

/**
 * This class use JSON for serialize object.
 */
public class JsonFormatter implements Formatter<String, String, Integer> {

    private final Gson gson;

    /**
     * Default constructor.
     */
    public JsonFormatter() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Score.class, (JsonDeserializer<?>) (json, typeOf, context) -> context.deserialize(json, JsonScore.class));
        gson = gsonBuilder.create();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String formatter(final List<? extends Score<String, Integer>> collection) {
        return gson.toJson(collection);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Score<String, Integer>> restore(final String formatted) {
        final Type type = new TypeToken<List<Score<String, Integer>>>() { }.getType();
        return gson.fromJson(formatted, type);
    }
}
