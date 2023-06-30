package ink.oxiemoron.colexicon.lingua;

import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.lateral.Tokens;

public class IUPACSyntaxError extends Exception {

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
