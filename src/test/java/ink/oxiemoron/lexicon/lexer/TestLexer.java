package ink.oxiemoron.lexicon.lexer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.mockito.Mockito;

public class TestLexer {

    String[] validCompounds = {
            "1,2,420,69-tetra",
            "9,6,024,21-tetra",
            "3,1,4,5,9,2,6-hepta",
            "1,6,1,8,0-penta",
            "1-mono",
            "1,2-di",
            "1,2,3-tri",
            "1,2,3,4-tetra",
            "1,2,3,4,5-penta"
    };

    String[] invalidCompounds = {
            "Now, this is a story all about how",
            "My life got flipped-turned upside down",
            "And I'd like to take a minute",
            "Just sit right there",
            "I'll tell you how I became the prince of a town called Bel-Air"
    };

    @Test
    public void testLexerWithValidCompounds() {

        for (String validCompound : validCompounds) {

            assertAll( () -> {

                        try {
                            Lexer lexer = new Lexer(validCompound);
                        } catch (Exception eh) {
                            throw eh;
                        }

                    }
            );
        }

    }

    @Test
    public void testLexerWithInvalidCompounds() {

        // mock of a test, that's for sure

        // but a reminder

    }

}
