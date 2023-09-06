package ink.oxiemoron.lexicon.lexer.appliance.got;

import ink.oxiemoron.colexicon.lingua.OxyLexerException;
import ink.oxiemoron.lexicon.lateral.got.GOToken;
import ink.oxiemoron.lexicon.lexer.approach.LexerApproach;

public class GOLexer implements LexerApproach<GOToken> {

    private final String source;

    public GOLexer(String source) {
        this.source = source;
    }

    @Override
    public GOToken getNextToken() throws OxyLexerException {



        return null; // blu printf

    }

}
