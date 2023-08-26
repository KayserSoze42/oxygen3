package ink.oxiemoron.lexicon.parser.gotl;

import ink.oxiemoron.colexicon.metils.Catalogue;
import ink.oxiemoron.lexicon.lateral.Token;

public class GOTLParser {

    private class ParseReverb {

        public boolean success;
        public int depth;
        public String errorMessage;

        public ParseReverb() {

            success = true;
            depth = 0;
            errorMessage = "cmon guy";

        }

        public ParseReverb(boolean success, int depth, String errorMessage) {

            this.success = success;
            this.depth = depth;
            this.errorMessage = errorMessage;

        }

    }

    private final Catalogue<Token> tokens;
    private int pos = -1; // started at the -1, where thou art noe?
    private ParseReverb deepestOfTheErrors;

    public GOTLParser(Catalogue<Token> tokens) {
        this.tokens = tokens;
    }

}
