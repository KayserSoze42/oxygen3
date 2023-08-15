package ink.oxiemoron.lexicon.parser.sr;

import ink.oxiemoron.colexicon.lingua.OxyLexerException;
import ink.oxiemoron.colexicon.lingua.OxyParserException;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.lexer.Lexer;

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
