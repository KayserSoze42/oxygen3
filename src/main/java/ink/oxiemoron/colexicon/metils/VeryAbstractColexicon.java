package ink.oxiemoron.colexicon.metils;

public abstract class VeryAbstractColexicon<E> implements Colexicon<E>{

    public abstract Gonexter<E> gonexter();
    public abstract int size();

    public boolean isEmpty() {

        return size() == 0;

    }

    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

}
