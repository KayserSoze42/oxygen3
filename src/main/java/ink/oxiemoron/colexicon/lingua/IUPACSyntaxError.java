package ink.oxiemoron.colexicon.lingua;

import ink.oxiemoron.lexicon.lateral.basic.Token;
import ink.oxiemoron.lexicon.lateral.basic.Tokens;

public class IUPACSyntaxError extends Exception{

    public IUPACSyntaxError(Token token, Tokens type) {

        super(String.format("%s expected but received %s, whatsup?", type, token));

    }

}
