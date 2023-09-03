package ink.oxiemoron.lexicon.reverbs.got;

public class GOTParseReverb {

    public boolean success;
    public int depth;
    public String errorMessage;

    public GOTParseReverb() {

        success = true;
        depth = 0;
        errorMessage = "cmon guy";

    }

    public GOTParseReverb(boolean success, int depth, String errorMessage) {

        this.success = success;
        this.depth = depth;
        this.errorMessage = errorMessage;

    }

}
