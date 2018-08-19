package it.unibo.goffo.fag.score.controller.serialize;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class handle the serialization of generic object.
 * @param <T> Object type to be serialized.
 */
@SuppressFBWarnings(value = "PATH_TRAVERSAL_IN", justification = "Tha path cannot be controlled by the user in this class the path come from ScoreControllerImpl")
public class LoadStoreManager<T> implements LoadStore<T> {

    private final Kryo kryoManager = new Kryo();

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveToFile(final String fileName, final T payload, final Class<T> classType) throws IOException {
        kryoManager.register(classType);
        final Output output = new Output(Files.newOutputStream(Paths.get(fileName)));
        kryoManager.writeObject(output, payload);
        output.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T loadFromFile(final String fileName, final Class<T> classType) throws IOException {
        kryoManager.register(classType);
        final Input input = new Input(Files.newInputStream(Paths.get(fileName)));
        final T tmp = kryoManager.readObjectOrNull(input, classType);
        input.close();
        return tmp;
    }
}
