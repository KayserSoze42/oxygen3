package lexicon.lateral;

public class Element {

    private String type;
    private String body;


    public Element(String type, String body) {
        this.type = type;
        this.body = body;
    }

    @Override
    public String toString() {

        return this.body;

    }

    public String getType() {
        return this.type;
    }

}
