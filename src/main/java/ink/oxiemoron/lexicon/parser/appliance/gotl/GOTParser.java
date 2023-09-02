package ink.oxiemoron.lexicon.parser.appliance.gotl;

import ink.oxiemoron.colexicon.lingua.OxyParserException;
import ink.oxiemoron.colexicon.metils.Catalogue;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.parser.approach.ParserApproach;
import ink.oxiemoron.lexicon.reverbs.got.ParseReverb;

import java.util.function.Function;

public class GOTParser implements ParserApproach<ParseReverb> {

    private final Catalogue<Token> tokens;
    private int pos = -1; // started at the -1, where thou art noe?
    private ParseReverb deepestOfTheErrors;

    public GOTParser(Catalogue<Token> tokens) {
        this.tokens = tokens;
    }

    public ParseReverb execute() throws OxyParserException {

        Catalogue<Function<Object, ParseReverb>> empressions = new Catalogue<>();
        // empressions.add(); -- lambda when?
        //
        //
        // str8 profits yall

        ParseReverb result = null;

        return result;

    }

}
