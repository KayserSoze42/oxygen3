package ink.oxiemoron.lexicon.amgine.constructa.interpiler;

import ink.oxiemoron.colexicon.metils.Pile;
import ink.oxiemoron.lexicon.lateral.Token;

import java.util.List;

public class Piler {

    private Climate climate;
    private InterState interState;

    public Piler() {


    }

    public static class Climate {


        public List<Token> rePoNo;
        public int position;
        public Pile<Token> pile;
        public boolean newLine;

        //..

    }
}
