package ink.oxiemoron.lexicon.lateral.got;

import ink.oxiemoron.lexicon.lateral.basic.Token;

public class GOToken {
    private GOTokens type;
    private String value; // elementary, before trying.. well elements/symbols

    public GOToken(GOTokens type, String value) {

        this.type = type;
        this.value = value;

    }

    public GOTokens getType() {
        return type;
    }

    public void setType(GOTokens type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int ayy = type.hashCode();
        final int yaa = value.hashCode();
        final int xXx = 69;

        return ayy * xXx * yaa; // what a dumb thing to write .. so anyhoo ...
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()){ // déclassé
            return false;
        }

        GOToken other = (GOToken) obj; // Remember on "Lost" when they met the Others? ... *points at my code (spaghetti)*

        return type == other.getType() && value.equals(other.getValue());
    }

    public String toString() {
        return type + "(" + value + ")"; // and this way too, idk we sha.. oh you know already ...
    }
}
