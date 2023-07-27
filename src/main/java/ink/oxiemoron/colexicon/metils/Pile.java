package ink.oxiemoron.colexicon.metils;

import java.io.Serializable;
import java.util.EmptyStackException;

public class Pile<E> extends Carrier<E> { // pile jemo pole

    public Pile() {
    }

    public boolean empty() {
        return size() == 0;
    }

    public E push(E object) {
        add(object);

        return object;
    }

    public E pop() {
        E object;
        int length = size();

        object = peek();
        removeObjectsAt(length - 1);

        return object;

    }

    public E peek() {
        int length = size();

        if (length == 0) {
            throw new EmptyStackException();
        }
        return objectAt(length - 1);
    }
}
