package colexicon.lingua;


public interface Gonextable<T> {

    Gonexter<T> gonexter();

    // the end, prbly
    // but let's hope not

    interface Gonexter<E> {

        boolean hasNext(); // gonext?

        E next(); // gonext!

        // for now..

    }
}
