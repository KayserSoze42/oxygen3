package ink.oxiemoron.lexicon.reverbs.got;

public class ParseReverb {

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
