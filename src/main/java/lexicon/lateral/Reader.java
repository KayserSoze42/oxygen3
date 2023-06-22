package lexicon.lateral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class Reader {

    private final char[] source;
    private int position = -1;

    public Reader (String string) {

        source = string.toCharArray();

    }

    public int getPosition() {
        return position;
    }

    public char read() throws IOException {

        position++;

        if (position >= source.length) {

            // Dude, you're a grown man. Why are you throwing a IOException?
            throw new IOException();

        }

        return source[position];

    }

    public char peek() throws IOException {

        // Peekaboo, will not need this prob
        // Mos def will not need any of this

        int peekPosition = position + 1;

        if (peekPosition >= source.length) {

            throw new IOException();

        }

        return source[peekPosition];

    }
}
