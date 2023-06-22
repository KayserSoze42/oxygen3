package lexicon.parser;

import lexicon.lateral.Token;
import lexicon.lexer.Lexer;

public class Parser {

    private Token currentToken;
    private Lexer lexer;

    public Parser(String source) throws Exception {

        try {
            lexer = new Lexer(source);

        } catch (Exception eh) {
            throw eh;
        }
    }

    public Lexer getLexd() {
        return lexer;
    }

    public void scan() {

        currentToken = lexer.getNextToken();

        if (currentToken != null) { // Another billion, great. Put it on my tab.

            System.out.println(currentToken); // Stealing, I mean borrowing this for "debug".

        }

    }



}
