package ink.oxiemoron.lexicon.lexer;

import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.lateral.Tokens;
import org.junit.jupiter.api.Test;

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
    public void test_newErrorToken_isOfErrorType_Word() {

        Tokens expectedTokensType = Tokens.Error;
        Tokens actualTokensType;

        try {

            Lexer lexer = new Lexer("☺");
            actualTokensType = lexer.getNextToken().getElement().getType(); // an awful chain reaction

            assertEquals(expectedTokensType, actualTokensType);

        } catch (Exception ignored) {}

    }

    @Test
    public void test_newLocationToken_isOfLocationType_Word() {

        Tokens expectedTokensType = Tokens.Location;
        Tokens actualTokensType;

        for (int i=1; i<70; i++) {

            try {

                String testString = Integer.toString(i) + "-meta"; // can't end with a numeric literal, right?
                // but will have to do it betr

                Lexer lexer = new Lexer(testString);
                actualTokensType = lexer.getNextToken().getElement().getType(); // another one

                assertEquals(expectedTokensType, actualTokensType);

            } catch (Exception ignored) {}
        }
    }

    @Test
    public void test_mewCommaToken_isOfCommaType_Word() {

        Tokens expectedTokensType = Tokens.Comma;
        Tokens actualTokensType;

        try {

            Lexer lexer = new Lexer(",");
            actualTokensType = lexer.getNextToken().getElement().getType(); // --", "", "--

            assertEquals(expectedTokensType, actualTokensType);

        } catch (Exception ignored) {}

    }



    @Test
    public void test_newDashToken_isOfDashType_Word() {

        Tokens expectedTokensType = Tokens.Dash;
        Tokens actualTokensType;

        try {

            Lexer lexer = new Lexer("-beta");
            actualTokensType = lexer.getNextToken().getElement().getType(); // --", "", "--

            assertEquals(expectedTokensType, actualTokensType);

        } catch (Exception ignored) {}

    }
    
    @Test
    public void test_newMultiplierToken_isOfMultiplierType_Word() {

        Tokens expectedTokensType = Tokens.Multiplier;
        Tokens actualTokensType;
        String[] multipliers = {"mono", "di", "tri", "tetra", "penta", "hexa", "hepta", "octa", "nona", "deca"};

        for (String multiplier : multipliers) {

            try {

                String testString = "1-" + multiplier;

                Lexer lexer = new Lexer(multiplier);

                lexer.getNextToken(); // Looks ugly
                lexer.getNextToken(); // But if the prev tests passed, this "should" pass
                // will improve, if i can

                actualTokensType = lexer.getNextToken().getElement().getType(); // --", "", "--

                assertEquals(expectedTokensType, actualTokensType);

            } catch (Exception ignored) {}

        }
        
    }
    

    @Test
    public void test_getNextToken_isOfTypeError_Word() {

        for (String validCompound : validCompounds) {

            assertAll( () -> {

                        try {

                            Lexer lexer = new Lexer(validCompound);

                            Token tolkien = lexer.getNextToken(); // since im watching e01, feels fine. Fine, just fine..

                            while (tolkien != null) {

                                assertNotEquals(Tokens.Error, tolkien.getElement().getType());
                                tolkien = lexer.getNextToken();
                            }

                        } catch (Exception ignored) {}
                    });
        }
    }

    @Test
    public void test_getNextToken_isOfTypeError_Wordnt() {

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
