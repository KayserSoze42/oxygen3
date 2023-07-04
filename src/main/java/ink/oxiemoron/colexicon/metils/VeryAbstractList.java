package ink.oxiemoron.colexicon.metils;

public abstract class VeryAbstractList<E> extends VeryAbstractColexicon<E> implements Catalogue<E>{

    public boolean add(E e) {
        add(size(), e);
        return true;
    }

    public void add(int index, E element) {
        throw new UnsupportedOperationException("cyo");
    }

    public abstract E get(int index);

    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

}
