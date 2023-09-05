package ink.oxiemoron.lexicon.lexer.approach;

import ink.oxiemoron.colexicon.lingua.OxyLexerException;

public interface LexerApproach<T> {

    public T getNextToken() throws OxyLexerException;

}
