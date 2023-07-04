package ink.oxiemoron.colexicon.metils;

import ink.oxiemoron.colexicon.lingua.Gonextable;

import java.util.function.IntFunction;

public interface Colexicon<E> extends Gonextable<E> {

    Object[] toArray();

    <T> T[] toArray(T[] a);

    default <T> T[] toArray(IntFunction<T[]> generator) { // okaii....
        return toArray(generator.apply(0));
    }

    boolean add(E e);

    boolean remove(Object o);

    boolean equals(Object o);

    int hashCode();

    // and then..

}
