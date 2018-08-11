package it.unibo.goffo.fag.score.controller.serialize;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * This class handle the serialization of generic object.
 * @param <T> Object type to be serialized.
 */
public class LoadStoreManager<T> implements LoadStore<T> {

    private final Kryo kryoManager = new Kryo();

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveToFile(final String fileName, final T payload, final Class<T> classType) throws FileNotFoundException {
        kryoManager.register(classType);
        try (Output output = new Output(new FileOutputStream(fileName))) {
            kryoManager.writeObject(output, payload);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T loadFromFile(final String fileName, final Class<T> classType) throws FileNotFoundException {
        kryoManager.register(classType);
        try (Input input = new Input(new FileInputStream(fileName))) {
            return kryoManager.readObject(input, classType);
        }
    }
}
