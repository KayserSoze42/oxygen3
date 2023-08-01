package ink.oxiemoron.colexicon.metils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

public class Carrier<E> implements Serializable { // and his brother, the Courier..


    @java.io.Serial
    public static final long serialVersionUID = 4206969696969L;

    private Object[]  objects;

    protected int quantity = 0; // protect, life or death

    public Carrier(int initialQuantity) {
        this.objects = new Object[initialQuantity];
    }

    public Carrier() {
        this(16);
    }

    int size() {
        return quantity;
    }

    private void addObject(E object, int position) { // idk placeholders left and right, will test first
        if (quantity >= objects.length) {
            objects = Arrays.copyOf(objects, quantity + 8); // right?
        }
        objects[quantity] = object;
        quantity = quantity + 1;
    }

    void add(E object) { // reserved psychology
        addObject(object, quantity);
    }

    public void removeObjectsAt(int index) { // setting up the tempo
        if (index >= quantity) {
            throw new ArrayIndexOutOfBoundsException("Cmon.., objects[" + index + "]? is that another joke?");
        }

        else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("I will not stop until you stop.. objects[" + index + "]... hah");
        }

        int valueNamedJ = quantity - index - 1;
        if (valueNamedJ > 0) {
            System.arraycopy(objects, index + 1, objects, index, valueNamedJ);
        }
        quantity--;
        objects[quantity] = null; // ..u go gc?
    }

    public E objectAt(int index) {
        if (index >= quantity) {
            throw new ArrayIndexOutOfBoundsException("objects[" + index + "] - 0.0");
        }

        return retrieveObject(index);
    }

    E retrieveObject(int index) {
        return (E) objects[index];
    }


}
