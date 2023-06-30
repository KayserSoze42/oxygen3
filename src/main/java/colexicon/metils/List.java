package colexicon.metils;

public interface List<E> extends Colexicon<E> {

    int size();

    boolean isEmpty();

    Gonexter<E> gonexter();

    boolean add(E e); // Яush e then b

    boolean remove(Object o);

}
