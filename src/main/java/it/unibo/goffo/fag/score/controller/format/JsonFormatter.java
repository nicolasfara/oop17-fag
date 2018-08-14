package it.unibo.goffo.fag.score.controller.format;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import it.unibo.goffo.fag.score.JsonScore;
import it.unibo.goffo.fag.score.Score;

import java.lang.reflect.Type;
import java.util.List;

/**
 * This class use JSON for serialize object.
 */
public class JsonFormatter implements Format<String> {

    private final Gson gson;

    /**
     * Default constructor.
     */
    public JsonFormatter() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Score.class, (JsonDeserializer) (json, typeOf, context) -> context.deserialize(json, JsonScore.class));
        gson = gsonBuilder.create();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <U, S> String formatter(final List<? extends Score<U, S>> collection) {
        return gson.toJson(collection);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <U, S> List<? extends Score<U, S>> restore(final String formatted, final Class<U> usernameClass, final Class<S> scoreClass) {
        final Type collectionType = new TypeToken<List<Score<U, S>>>() { }
                .where(new TypeParameter<U>() { }, TypeToken.of(usernameClass))
                .where(new TypeParameter<S>() { }, TypeToken.of(scoreClass))
                .getType();
        return gson.fromJson(formatted, collectionType);
    }
}
