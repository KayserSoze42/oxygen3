package ink.oxiemoron.colexicon.metils;

import java.util.Arrays;
import java.util.Iterator;

public class Carrier<E> extends VeryAbstractList<E> implements Catalogue<E> { // pigeons... it's a thing
    // https://en.wikipedia.org/wiki/IP_over_Avian_Carriers , how do you do it? hahahah... sry...


    protected Object[] objects;

    protected int objectQuantity;

    protected int capacityIncrement;

    private static final long serialVersionUID = -4204204204204204206L;

    public Carrier(int initialCapacity, int capacityIncrement) {
        super();
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("<0....");
        }
        this.objects = new Object[initialCapacity];
        this.capacityIncrement = capacityIncrement;
    }

    public Carrier(int initialCapacity) { // cons o' tractor overload..
        // your jokes are bad, and you should feel bad too
        this(initialCapacity, 0);

    }

    public Carrier() {
        this(3);
    }

    public Carrier(Colexicon<? extends  E> c) { // ? extends F in the chat..


    }


    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }


    public Gonexter<E> gonexter() {
        return null;
    }

    public boolean add(E e, Object[] objects, int s) {
        if (s == objects.length) {
            // 1up
        }
        objects[s] = e;
        objectQuantity = s + 1;
        return true; // thru?
    }

    public synchronized boolean add(E e) {
        add(e, objects, objectQuantity);
        return true;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    private Object[] grow(int bareMinimum) {
        int oldQuantity = objects.length;
        int newQuantity = oldQuantity + 1; // jdk.internal.cry
        return objects = Arrays.copyOf(objects, newQuantity);
    }

    private Object[] grow() {
        return grow(objectQuantity + 1);
    }


}

// ye ye, look at this guy reinventing the wheel
// but rly idk wth is going on

// since we already are gettin' some "objects" from the lexer
// i always though about testing different data structs here, a ref to my small step

// this is just a basic sketch, to figure out stuff
// will def rewrite
















// since this may be my magnum opus (and it made me so happy again)
// lets doeit right*










// *Directing a person right, might give different results*
//   "idi pravo" - go straight (srb + some neighbours)
//   "pravá strana" - right side (cz + some neighbour(s))

// protoslavs and their etymologyz**






// **see also cz/sk && pl simis/difis, among (all) others hah