package ink.oxiemoron.lexicon.amgine.constructa.interpiler;

import ink.oxiemoron.colexicon.lingua.OxyExecutionException;
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

        // ..

    }

    public void execute() throws OxyExecutionException {
        execute(climate.rePoNo.size()); // totoro to-to-ro ♫ ♪
    }

    public void execute(int numero) throws OxyExecutionException {

        // .. ...

    }
}
