package ink.oxiemoron.chemistry.law.structure.bit;

public enum Bit {

    Carbon("Carbon", +4),
    Hydrogen("Hydrogen", +1),
    Oxygen("Oxygen", -2);


    public final int valency;
    public final String name;

    private Bit(String name, int valency) { // hahahahaha
        this.name = name;
        this.valency = valency;
    }
}
