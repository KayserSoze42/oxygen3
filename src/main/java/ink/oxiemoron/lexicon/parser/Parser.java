package ink.oxiemoron.lexicon.parser;

import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.lateral.Tokens;
import ink.oxiemoron.lexicon.lexer.Lexer;

public class Parser {

    private Token currentToken;
    private Lexer lexer;

    public Parser(String source) throws Exception {

        try {
            lexer = new Lexer(source);
            scan(); // ch is the next character to process

        } catch (Exception eh) {
            throw eh;
        }
    }

    public Lexer getLexd() {
        return lexer;
    }

    private boolean isNextToken(Tokens type) {

        if ((currentToken == null) || (currentToken.getElement().getType()) != type) { // Houston, we have a problem
                                                   // ^ it might be here
            return false;
        }

        return true;

    }

    private void expect(Tokens type) throws IUPACSyntaxError { // What to expect, when you're throwing exceptions

        if (isNextToken(type)) {
            scan();
            return;
        }
        throw new IUPACSyntaxError(currentToken, type);

    }

    public void scan() {

        currentToken = lexer.getNextToken();

        if (currentToken != null) { // Another billion, great. Put it on my tab.

            System.out.println(currentToken); // Stealing, I mean borrowing this for "debug".

        }

    }


}

class IUPACSyntaxError extends Exception {

    private static final long serialVersionUID = 1l;

    private Token tokenFound;
    private Tokens typeExpected;


    public IUPACSyntaxError(Token tokenFound, Tokens typeExpected) {

        this.tokenFound = tokenFound;
        this.typeExpected = typeExpected;

    }

    void print() {

        System.out.println("Expected token type:" + typeExpected);
        return; // go home, u drunk

    }

}
