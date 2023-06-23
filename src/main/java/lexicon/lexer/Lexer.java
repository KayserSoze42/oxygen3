package lexicon.lexer;

import lexicon.lateral.Element;
import lexicon.lateral.Reader;
import lexicon.lateral.Token;
import lexicon.lateral.Tokens;
import lexicon.lateral.regex.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Lexer {

    // Ok, so the syntax is
    // 1, 3, 7-Trimethylpurine-2,6-dione
    // Location , Location , Location - Multiplier FunctionalGroup(s) - Location , Location - Base/Group
    // What can we do with this?

    // I am hoping to achieve something using only simple-bonded non-cyclic stuff, but let's see how far is that, eh?

    // So the idea so far is that we tokenize and parse the above-mentioned blob, but if there's our good old friend ","
    // after a string literal, well let's parse one more, eh?

    // 1, 3, 7-Trimethylpurine-2,6-dione "," (6aR,9R)- N,N- diethyl- 7-methyl- 4,6,6a,7,8,9- hexahydroindolo- [4,3-fg] quinoline- 9-carboxamide
    // hopefully

    private boolean eof;
    private char character;

    private int startPosition;
    private int endPosition;

    private Reader source;
    private StringBuilder bob;

    private Pattern pattern;
    private Matcher matcher;


    public Lexer (String string) throws Exception{

        source = new Reader(string);
        character = source.read(); // As that person on github says, ch is the next character to process

        bob = new StringBuilder();

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

    public Token getNextToken() {

        // Trying to be smart, usually yields in dumb stuff
        // So here we are
        if (bob == null) {
            bob = new StringBuilder();
        } else {
            bob.setLength(0);
        }

        // A billion-dollar mistake, thank grep I don't have that money..
        if (eof) {
            return null;
        }

        try {
            while (Character.isWhitespace(character)) {
                character = source.read();
            }

        } catch (Exception eh) {
            eof = true; // And yet I feel eof is unambiguous
            return getNextToken();
        }

        startPosition = source.getPosition(); // The beginning
        endPosition = startPosition - 1; // The one before the beginning


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

        if (Character.isAlphabetic(character)) { // Bare bones and joy

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

            // By now, bob should have built a blob
            String blob = bob.toString();
            // Multiplier(s) x Group(s) x Base

            // I should keep in mind that numeric literals also provide locations for the funny bonds as I remember
            // funny place to remember that, but it would split the string

            // I feel like I'm missing some design. The grand one excluded, I'll keep it for the sake of going on
            // In case of a Multiplier pattern match, panik!

            pattern = Pattern.compile(Regex.MULTIPLIER.pattern);
            matcher = pattern.matcher(blob);

            // Capture groups? lets hope not
            if (matcher.matches()) {

                startPosition = matcher.start();
                endPosition = matcher.end() - 1;

                return newMultiplierToken(startPosition, endPosition, matcher.group());

            }

        }

        return null;

    }

}
