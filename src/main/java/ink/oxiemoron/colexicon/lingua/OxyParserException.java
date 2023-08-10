package ink.oxiemoron.colexicon.lingua;

public class OxyParserException extends Exception{

    public OxyParserException (String message) {
        super("OXY ERROR: " + message);
    }

}
