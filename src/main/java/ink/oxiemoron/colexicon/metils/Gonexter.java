package ink.oxiemoron.colexicon.metils;

import java.util.Objects;
import java.util.function.Consumer;

public interface Gonexter<E> {

    boolean hasNext(); // gonext ?

    E next(); // gonext !

    default void remove() {throw new UnsupportedOperationException("addn't");}

    default void forEachLeft(Consumer<? super E> action) { // worst. superhero. name. ever.
        Objects.requireNonNull(action);
        while (hasNext()){
            action.accept(next());
        }

    }

}
