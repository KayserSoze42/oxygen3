package lexicon.lateral;

import java.util.HashMap;

public class Element {

    private Tokens type;
    private String body;

    private static HashMap<String, Element> lesPool = new HashMap<String, Element>();


    private Element(Tokens type, String body) {
        this.type = type;
        this.body = body;
    }

    @Override
    public String toString() {

        return this.body;

    }

    public Tokens getType() {
        return this.type;
    }

    public static Element craft (String body, Tokens type) { // Another day at the factory, I kinda see why.

        Element element = lesPool.get(body);

        if (element == null) { // Check if the pool water is warm

            element = new Element(type, body);
            lesPool.put(body, element);

        }

        return element;

    }

}
