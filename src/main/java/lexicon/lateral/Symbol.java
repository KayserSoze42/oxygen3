package lexicon.lateral;

public class Symbol {

    private String type;
    private String name;


    public Symbol (String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

}
