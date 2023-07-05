package ink.oxiemoron.amgine.abstracta;

import ink.oxiemoron.lexicon.parser.Parser;

public abstract class AmgineEngine {

    private String source;

    public AmgineEngine(String source) {

        this.source = source;

    } // cs 1.6 > css, cmm, idk

    protected abstract void compileRoutine();


}
