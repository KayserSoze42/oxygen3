package ink.oxiemoron.lexicon.lexer;

import ink.oxiemoron.colexicon.lingua.OxyLexerException;
import ink.oxiemoron.colexicon.lingua.OxyReaderException;
import ink.oxiemoron.colexicon.metils.Pile;
import ink.oxiemoron.lexicon.lateral.basic.Element;
import ink.oxiemoron.lexicon.lateral.basic.Reader;
import ink.oxiemoron.lexicon.lateral.basic.Token;
import ink.oxiemoron.lexicon.lateral.basic.Tokens;
import ink.oxiemoron.lexicon.lateral.basic.regex.Regex;

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
    private StringBuilder bob;
    private Pile<Token> compoundPile = new Pile<>();

    private final static Pattern MULTI_PATTERN = Pattern.compile(
            String.format(
                    "(?<multiplier>%s)?(?<radical>%s)?(?<root>%s)?",
                    Regex.MULTIPLIER.pattern,
                    Regex.RADICAL.pattern,
                    Regex.ROOT.pattern
            ));



    public Lexer (String string) throws OxyLexerException {

        source = new Reader(string.toLowerCase());

        try {

            character = source.read();

        } catch(OxyReaderException ore) {

            ore.printStackTrace();
            throw new OxyLexerException("Reader error");

        }

        bob = new StringBuilder();

    }

    public Token newErrorToken(int left, int right, String badBody) {
        return new Token(left, right, Element.craft(badBody, Tokens.Error));
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

    public Token newSemicolonToken(int left, int right, String semicolon) {
        return new Token(left, right, Element.craft(semicolon, Tokens.Semicolon));
    }

    public Token newStringToken(int left, int right, String literal) {
        return new Token(left, right, Element.craft(literal, Tokens.String));
    }

    public Token getNextToken(){

        if (!compoundPile.empty()) {
            return compoundPile.pop();
        }

        if (bob == null) {
            bob = new StringBuilder(); // for my best friend Lewd Block
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

        if (Character.isDigit(character)) {

            try {

                do {

                    endPosition++;
                    bob.append(Character.toLowerCase(character));
                    character = source.read();

                } while (Character.isDigit(character));

            } catch (Exception eh) {

                eof = true;
            }

            return newLocationToken(startPosition, endPosition, bob.toString());

        }

        if (character == ',') {

            try {
                endPosition++;
                bob.append(character);
                character = source.read();

            } catch (Exception eh) {

                eof = true;
            }

            return newCommaToken(startPosition, endPosition, bob.toString());
        }

        if (character == ';') {

            try {
                endPosition++;
                bob.append(character);
                character = source.read();

            } catch (Exception eh) {

                eof = true;

                if (source.getPosition() >= source.getLength()) {
                    return newSemicolonToken(startPosition, endPosition, ";");
                }

                return newErrorToken(startPosition, endPosition, bob.toString());

            }

            return newSemicolonToken(startPosition, endPosition, bob.toString());
        }

        if (character == '-') {

            try {

                endPosition++;
                bob.append(character);
                character = source.read();

            } catch (Exception eh) {

                eof = true;

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
            }

            multiMatcher = MULTI_PATTERN.matcher(bob.toString());

            if (multiMatcher.matches()) {

                if (multiMatcher.group("root") != null) {
                    compoundPile.push(newRootToken(
                            multiMatcher.start("root") + startPosition,
                            multiMatcher.end("root") + startPosition - 1,
                            multiMatcher.group("root")
                    ));
                }

                if (multiMatcher.group("radical") != null) {
                    compoundPile.push(newRadicalToken(
                            multiMatcher.start("radical") + startPosition,
                            multiMatcher.end("radical") + startPosition - 1,
                            multiMatcher.group("radical")
                    ));
                }

                if (multiMatcher.group("multiplier") != null) {
                    compoundPile.push(newMultiplierToken(
                            multiMatcher.start("multiplier") + startPosition,
                            multiMatcher.end("multiplier") + startPosition - 1,
                            multiMatcher.group("multiplier")
                    ));
                }

            } else {
                // System.out.println("*wrong*");
                return newStringToken(startPosition, endPosition, bob.toString());
                // making room for some things but idk..
            }



        }

        if (compoundPile.empty()) {
            return null;
        } else {
            return getNextToken();
        }

    }

}
