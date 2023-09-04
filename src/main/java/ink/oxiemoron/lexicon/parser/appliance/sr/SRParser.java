package ink.oxiemoron.lexicon.parser.appliance.sr;

import ink.oxiemoron.colexicon.lingua.OxyLexerException;
import ink.oxiemoron.colexicon.lingua.OxyParserException;
import ink.oxiemoron.lexicon.lateral.basic.Token;
import ink.oxiemoron.lexicon.lexer.appliance.basic.Lexer;

public class SRParser {

    private Token currentToken;
    private Lexer lexer;

    public SRParser(String source) throws OxyParserException {

        try {
            lexer = new Lexer(source);
        } catch (OxyLexerException olé) {

            System.out.println(olé.getMessage());
            throw new OxyParserException("rip");
        }

    }

    public Lexer getYoselfLexed() {return lexer;}


    // we'll get there... when we get where?!?

}
