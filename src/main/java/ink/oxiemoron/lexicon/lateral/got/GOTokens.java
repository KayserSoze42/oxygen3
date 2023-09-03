package ink.oxiemoron.lexicon.lateral.got;

import java.util.regex.Pattern;

public enum GOTokens {

    LOCATION_TOK("loc", 1),
    COMMA_TOK(",", 0),
    DASH_TOK("-", -1),
    MULTI_TOK("idk", 1), // for noe, idk might try insertion here..
    RADICAL_TOK("idk2", 1),
    ROOT_TOK("2idk4me", 69),
    SEMICOLON_TOK(";", 0); // here def, thx js, lol


    private Pattern pattern;
    private int importance;

    GOTokens(String regex, int importance) {

        this.pattern = Pattern.compile(regex);
        this.importance = importance;

    }

    public Pattern getPatternd() {
        return pattern;
    }

    public int getImportanced() {
        return importance;
    }

}
