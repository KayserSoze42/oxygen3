package lexicon.lateral.regex;

public enum Regex {

    MULTIPLIER("mono|di|tri|tetra|penta|hexa|hepta|octa|nona|deca");

    public final String pattern;

    private Regex(String pattern) {
        this.pattern = pattern;
    }
}
