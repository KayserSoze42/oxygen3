package lexicon.lexer;

import lexicon.lateral.Reader;
import lexicon.lateral.Token;


public class Lexer {

    private boolean eof;
    private char character;

    private Reader source;


    public Lexer (String string) {

    }

    public Token newToken(int left, int right, String symbol) {
        return new Token(left, right, symbol);
    }

    public Token getNext() {
        return null;
    }

}
