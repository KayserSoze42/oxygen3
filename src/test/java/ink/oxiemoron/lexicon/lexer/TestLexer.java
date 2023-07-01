package ink.oxiemoron.lexicon.lexer;

import ink.oxiemoron.colexicon.lingua.IUPACSyntaxError;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.lateral.Tokens;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

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
            "♪Now, this is a story all about how",
            "My life got flipped-turned upside down",
            "And I'd like to take a minute",
            "Just sit right there",
            "I'll tell you how I became the fool of a place called Blue Planet♫"
    };


    @Test
    public void test_getNextToken_ValidCompounds_TokensType_NotError() {

        for (String validCompound : validCompounds) {

            assertAll( () -> {

                        try {

                            Lexer lexer = new Lexer(validCompound);

                            Token tolkien = lexer.getNextToken(); // since im watching e01, feels fine. Fine, just fine..

                            while (tolkien != null) {

                                assertNotEquals(Tokens.Error, tolkien.getElement().getType());
                                tolkien = lexer.getNextToken();
                            }

                        } catch (Exception eh) {

                            throw eh;

                        }

                    });
        }
    }

    @Test
    public void test_getNextToken_InvalidCompounds_TokensType_Error() {

        for (String invalidCompoundButHotLyrics : invalidCompounds) {

            assertAll(() -> {

                Lexer lexer = new Lexer(invalidCompoundButHotLyrics);

                Token tolkien = lexer.getNextToken();

                while (tolkien != null) {

                    tolkien = lexer.getNextToken();

                    assertEquals(Tokens.Error, tolkien.getElement().getType());

                }
            });
        }
    }



}
