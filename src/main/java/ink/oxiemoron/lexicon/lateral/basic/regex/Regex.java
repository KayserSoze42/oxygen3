package ink.oxiemoron.lexicon.lateral.basic.regex;

public enum Regex {

    MULTIPLIER("mono|di|tri|tetra|penta|hexa|hepta|octa|nona|deca"),
    RADICAL("methyl|ethyl|propyl|butyl|pentyl|hexyl|heptyl|octyl|nonyl|decyl"),
    ROOT("methane|ethane|propane|butane|pentane|hexane|heptane|octane|nonane|decane");

    public final String pattern;

    private Regex(String pattern) {
        this.pattern = pattern;
    }
}
