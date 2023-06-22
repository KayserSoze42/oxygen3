package lexicon.lexer;

import lexicon.lateral.Reader;
import lexicon.lateral.Token;


public class Lexer {

    private boolean eof;
    private char character;

    private int startPosition;
    private int endPosition;

    private Reader source;


    public Lexer (String string) throws Exception{

        source = new Reader(string);
        character = source.read(); // As that person on github says, ch is the next character to process

    }

    public Token newToken(int left, int right, String element) {
        return new Token(left, right, element); // OOPsie Xzibit A
    }

    public Token getNextToken() {

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

        StringBuilder body = new StringBuilder();

        try {

            do { // do-while, not even... well, actually at least once

                endPosition++; // The end is near
                body.append(character); // Start building using current char
                character = source.read(); // ch is the next character to process, lol

            } while (Character.isJavaIdentifierPart(character)); // I'll "borrow" this from mah pals at gh and java

        } catch (Exception eh) {
            eof = true;
        }

        return newToken(startPosition, endPosition, body.toString());

    }

}
