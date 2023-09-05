package ink.oxiemoron.lexicon.parser.appliance.got;

import ink.oxiemoron.colexicon.lingua.OxyLexerException;
import ink.oxiemoron.colexicon.lingua.OxyParserException;
import ink.oxiemoron.colexicon.metils.Catalogue;
import ink.oxiemoron.lexicon.lateral.got.GOToken;
import ink.oxiemoron.lexicon.lateral.got.GOTokens;
import ink.oxiemoron.lexicon.lexer.appliance.got.GOLexer;
import ink.oxiemoron.lexicon.parser.approach.ParserApproach;
import ink.oxiemoron.lexicon.reverbs.got.GOTParseReverb;

import java.util.function.Function;

public class GOTParser implements ParserApproach<GOTParseReverb> {

    private final Catalogue<GOToken> tokens;
    private int pos = -1; // started at the -1, where thou art noe?
    private GOTParseReverb deepestOfTheErrors;

    public GOTParser() {

        this.tokens = new Catalogue<>();

    }

    public GOTParser(Catalogue<GOToken> tokens) {
        this.tokens = tokens;
    }

    public GOTParseReverb execute() throws OxyParserException {

        Catalogue<Function<Object, GOTParseReverb>> empressions = new Catalogue<>();

        GOTParseReverb result = null;

        return result;

    }

    private GOToken matchd() {
        return tokens.get(++pos);
    }

    private GOTParseReverb matchToken(GOToken token, GOTokens type) {

        return new GOTParseReverb(); // got rekt 4 noe, gotteeem

    }

    private Catalogue<GOToken> getGOTokened() throws OxyParserException, OxyLexerException {

        Catalogue<GOToken> gotokens = new Catalogue<GOToken>();

        GOLexer goLexer = new GOLexer("");

        while (true) {
            break; // hammer time, y'all
            // celebrate good felings,





            // one more time
        }

        return gotokens;

    }

}
