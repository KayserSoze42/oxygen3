package ink.oxiemoron.colexicon.metils;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Catalogue<E> implements Iterable<E>{


    private static final int DEFAULT_QUANTITY = 64;

    private int quantity; // hmm
    private E[] objects;

    public Catalogue() {
        clear();
    }

    public int size() {
        return quantity;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void warrantVolume(int neoVolume) {

        if (neoVolume < quantity) return;

        E[] temp = objects;
        objects = (E[]) new Object[neoVolume]; // check yo self, be4 u generics yo self
        for (int i = 0; i < size(); i++) {
            objects[i] = temp[i];
        }

    }

    public void clear() {
        quantity = 0;
        warrantVolume(DEFAULT_QUANTITY);
    }

    public void snipSnap() {
        warrantVolume(size());
    }

    public E get(int index) {

        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return objects[index];

    }

    public E set(int index, E newbie) {

        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        E temp = objects[index];
        objects[index] = newbie;
        return temp;

    }

    public boolean add(E newbie) {

        add(size(), newbie);
        return true;

    }

    public void add (int index, E newbie) {

        if (objects.length == size()) {

            warrantVolume(size() * 2 +1); // +1

        }

        for (int i = quantity; i > index; i--) {

            objects[i] = objects[i-1]; // -1

        }

        objects[index] = newbie;
        quantity++;

    }

    public E remove (int index) {

        E removie = objects[index];

        for (int i = index; i < (size() -1); i++) { // -1

            objects[i] = objects[i+1]; // +1

        }

        quantity--;

        return removie;

    }

    @Override
    public Iterator<E> iterator() {
        return new CatalogueIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return Iterable.super.spliterator();
    }

    private class CatalogueIterator implements Iterator<E> {

        private int current = 0;

        @Override
        public void remove() {
            Iterator.super.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Iterator.super.forEachRemaining(action);
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            if (!hasNext()) {

                throw new NoSuchElementException();

            }
            return objects[current++];
        }
    }
}
