package ink.oxiemoron.lexicon.lateral;

import ink.oxiemoron.colexicon.lingua.OxyReaderException;

import java.io.IOException;

public class Reader {

    private final char[] source;
    private int position = -1;

    public Reader (String string) {

        source = string.toCharArray();

    }

    public int getLength() {
        return source.length;
    }

    public int getPosition() {
        return position;
    }

    public char read() throws OxyReaderException {

        position++;

        if (position >= source.length) {

            // Dude, you're a grown man. Why are you throwing an IOException?
            throw new OxyReaderException("Lateral Reader Error: invalid position");

        }

        return source[position];

    }

    public char peek() throws OxyReaderException {

        // Peekaboo, will not need this prob
        // Mos def will not need any of this

        int peekPosition = position + 1;

        if (peekPosition >= source.length) { // peek should not complain.. but w/e 4 noe

            throw new OxyReaderException("Lateral Reader Error: peeked beyond the limits, bruh..");

        }

        return source[peekPosition];

    }
}
