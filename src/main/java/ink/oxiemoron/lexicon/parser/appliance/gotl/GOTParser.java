package ink.oxiemoron.lexicon.parser.appliance.gotl;

import ink.oxiemoron.colexicon.lingua.OxyParserException;
import ink.oxiemoron.colexicon.metils.Catalogue;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.parser.approach.ParserApproach;
import ink.oxiemoron.lexicon.reverbs.got.GOTParseReverb;

import java.util.function.Function;

public class GOTParser implements ParserApproach<GOTParseReverb> {

    private final Catalogue<Token> tokens;
    private int pos = -1; // started at the -1, where thou art noe?
    private GOTParseReverb deepestOfTheErrors;

    public GOTParser() {

        this.tokens = new Catalogue<>();

    }

    public GOTParser(Catalogue<Token> tokens) {
        this.tokens = tokens;
    }

    public GOTParseReverb execute() throws OxyParserException {

        Catalogue<Function<Object, GOTParseReverb>> empressions = new Catalogue<>();
        // empressions.add(); -- lambda when?
        //
        //
        // str8 profits yall

        GOTParseReverb result = null;

        return result;

    }

}
