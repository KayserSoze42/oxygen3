package ink.oxiemoron.lexicon.lexer;

import ink.oxiemoron.colexicon.metils.Pile;
import ink.oxiemoron.lexicon.lateral.Element;
import ink.oxiemoron.lexicon.lateral.Reader;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.lateral.Tokens;
import ink.oxiemoron.lexicon.lateral.regex.Regex;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Lexer {

    // Ok, so the syntax is
    // 1, 3, 7-Trimethylpurine-2,6-dione
    // Location , Location , Location - Multiplier FunctionalGroup(s) - Location , Location - Base/Group
    // What can we do with this?

    // I am hoping to achieve something using only simple-bonded non-cyclic stuff, but let's see how far is that, eh?

    // So the idea so far is that we tokenize and parse the above-mentioned blob, but if there's our good old friend ";"**
    // after a string literal, well let's parse one more, eh?

    // 1, 3, 7-Trimethylpurine-2,6-dione ";" (6aR,9R)- N,N- diethyl- 7-methyl- 4,6,6a,7,8,9- hexahydroindolo- [4,3-fg] quinoline- 9-carboxamide
    // hopefully

    private boolean eof;
    private char character;

    private int startPosition;
    private int endPosition;

    private Reader source;
    private StringBuffer bob;
    private Pile<Token> compoundPile = new Pile<>();

    private final static Pattern MULTI_PATTERN = Pattern.compile(
            String.format(
                    "(?<multiplier>%s)?+(?<radical>%s)?+(?<root>%s)?+",
                    Regex.MULTIPLIER.pattern,
                    Regex.RADICAL.pattern,
                    Regex.ROOT.pattern
            ));



    public Lexer (String string) throws Exception{

        source = new Reader(string.toLowerCase());
        character = source.read(); // As that person on github says, ch is the next character to process

        bob = new StringBuffer();

    }

    public Token newErrorToken(int left, int right, String badBody) {
        return new Token(left, right, Element.craft(badBody, Tokens.Error)); // OOPsie Xzibit A
    }

    public Token newLocationToken(int left, int right, String number) {
        return new Token(left, right, Element.craft(number, Tokens.Location));
    }

    public Token newCommaToken(int left, int right, String comma) {
        return new Token(left, right, Element.craft(comma, Tokens.Comma));
    }

    public Token newDashToken(int left, int right, String dash) {
        return new Token(left, right, Element.craft(dash, Tokens.Dash));
    }

    public Token newMultiplierToken(int left, int right, String multiplier) {
        return new Token(left, right, Element.craft(multiplier, Tokens.Multiplier));
    }

    public Token newRadicalToken(int left, int right, String radical) {
        return new Token(left, right, Element.craft(radical, Tokens.Radical));
    }

    public Token newRootToken(int left, int right, String root) {
        return new Token(left, right, Element.craft(root, Tokens.Root));
    }

    public Token getNextToken() {

        if (!compoundPile.empty()) {
            return compoundPile.pop();
        }


        if (bob == null) {
            bob = new StringBuffer();
        } else {
            bob.setLength(0);
        }

        if (eof) {
            return null;
        }

        try {
            while (Character.isWhitespace(character)) {
                character = source.read();
            }

        } catch (Exception eh) {
            eof = true;
            return getNextToken();
        }

        startPosition = source.getPosition();
        endPosition = startPosition - 1;


        // In case we get a number, which as I can tell acts only as a location in the structure
        if (Character.isDigit(character)) {

            try {

                do { // do-while, not even... well, actually at least once

                    endPosition++; // The end is near
                    bob.append(character); // Start building using current char
                    character = source.read(); // ch is the next character to process, lol

                } while (Character.isDigit(character)); // A "borrow" from [PpGg]als at gh and java
                // I'm keeping the do while, hoping that we start parsin' some big units in the future, lol

            } catch (Exception eh) {

                eof = true;
                return newErrorToken(startPosition, endPosition, bob.toString());
                // The name can't end with a number?
            }

            return newLocationToken(startPosition, endPosition, bob.toString());

        }

        // A case of comma for multiple locations, alpha is omega and return a single char token?
        if (character == ',') {

            try {
                endPosition++;
                bob.append(character);
                character = source.read();

            } catch (Exception eh) {

                eof = true;
                return newErrorToken(startPosition, endPosition, bob.toString());
                // Again, can't end with a ",". Is this pre-parsing? sudo rm -rf?
            }

            return newCommaToken(startPosition, endPosition, bob.toString());
        }

        // Check for the dash, another single char token?
        if (character == '-') {

            try {

                endPosition++;
                bob.append(character);
                character = source.read();

            } catch (Exception eh) {

                eof = true;
                return newErrorToken(startPosition, endPosition, bob.toString());
                // :120y p

            }

            return newDashToken(startPosition, endPosition, bob.toString());

        }

        if (Character.isAlphabetic(character)) {


            Matcher multiMatcher;

            try {

                do {
                    endPosition++;
                    bob.append(character);
                    character = source.read();

                } while (Character.isAlphabetic(character));



            } catch (Exception eh) {

                eof = true;
                // It should be fine when we eof with alphabetic? Right? ... Right??
            }

            multiMatcher = MULTI_PATTERN.matcher(bob.toString());
            System.out.println(bob.toString());

            if (multiMatcher.matches()) {

                System.out.println(multiMatcher.group("multiplier"));
                System.out.println(multiMatcher.group("radical"));
                System.out.println(multiMatcher.group("root"));

                if (multiMatcher.group("root") != null) {
                    compoundPile.push(newRootToken(
                            multiMatcher.start("root"),
                            multiMatcher.end("root"),
                            multiMatcher.group("root")
                    ));
                }

                if (multiMatcher.group("radical") != null) {
                    compoundPile.push(newRadicalToken(
                            multiMatcher.start("radical"),
                            multiMatcher.end("radical"),
                            multiMatcher.group("radical")
                    ));
                }

                if (multiMatcher.group("multiplier") != null) {
                    compoundPile.push(newMultiplierToken(
                            multiMatcher.start("multiplier"),
                            multiMatcher.end("multiplier"),
                            multiMatcher.group("multiplier")
                    ));
                }

                return getNextToken();

            } else {
                System.out.println("False");
            }



        }

        return null;

    }

}
