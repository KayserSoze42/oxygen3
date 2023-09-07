package ink.oxiemoron.lexicon.lexer.appliance.got;

import ink.oxiemoron.colexicon.lingua.OxyLexerException;
import ink.oxiemoron.colexicon.lingua.OxyReaderException;
import ink.oxiemoron.lexicon.lateral.basic.Reader;
import ink.oxiemoron.lexicon.lateral.got.GOToken;
import ink.oxiemoron.lexicon.lateral.got.GOTokens;
import ink.oxiemoron.lexicon.lexer.approach.LexerApproach;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GOLexer implements LexerApproach<GOToken> {

    private final Reader source;
    private char character;

    public GOLexer(String string) throws OxyLexerException{
        source = new Reader(string.toLowerCase());

        try {
            character = source.read();
        } catch (OxyReaderException ore) {
            ore.printStackTrace();
            throw new OxyLexerException("GOLexer Exception: Reader error");
        }
    }

    private String readBlob() throws OxyLexerException {

        return "ya";

    }

    @Override
    public GOToken getNextToken() throws OxyLexerException {

        GOTokens currRelevantType = GOTokens.values()[0];

        String regex = currRelevantType.getPatternd().pattern();

        Matcher matcher = Pattern.compile(regex).matcher(readBlob());

        return null;

    }

}
