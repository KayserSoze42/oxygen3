package ink.oxiemoron.lexicon.parser.approach;

import ink.oxiemoron.colexicon.lingua.OxyParserException;

public interface ParserApproach<T> {

    public T execute() throws OxyParserException;

}
