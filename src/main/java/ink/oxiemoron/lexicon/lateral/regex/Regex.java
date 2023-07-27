package ink.oxiemoron.lexicon.lateral.regex;

public enum Regex {

    MULTIPLIER("mono|di|tri|tetra|penta|hexa|hepta|octa|nona|deca"),
    BASE("meth|eth|prop|but|pent|hex|hept|oct|non|dec"),
    RADICAL("methyl|ethyl|propyl|butyl|pentyl|hexyl|heptyl|octyl|nonyl|decyl"),
    ROOT("methane|ethane|propane|butane|pentane|hexane|heptane|octane|nonane|decane");

    public final String pattern;

    private Regex(String pattern) {
        this.pattern = pattern;
    }
}
