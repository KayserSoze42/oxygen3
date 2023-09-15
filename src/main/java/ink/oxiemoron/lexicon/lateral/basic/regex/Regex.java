package ink.oxiemoron.lexicon.lateral.basic.regex;

public enum Regex {

    MULTIPLIER("mono|di|tri|tetra|penta|hexa|hepta|octa|nona|deca"),
    RADICAL("methyl|ethyl|propyl|butyl|pentyl|hexyl|heptyl|octyl|nonyl|decyl"),
    ALKANE("methane|ethane|propane|butane|pentane|hexane|heptane|octane|nonane|decane"),
    ALKENE("ethene|propene|butene|pentene|hexene|heptene|octene|nonene|decene"),
    ALKYNE("ethyne|propyne|butyne|pentyne|hexyne|heptyne|octyne|nonyne|decyne");;

    public final String pattern;

    private Regex(String pattern) {
        this.pattern = pattern;
    }
}
