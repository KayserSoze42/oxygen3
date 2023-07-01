package ink.oxiemoron.lexicon.lateral;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class TestReader {

    private static final String TEST_STRING = "Per aspera ad astra";

    @Test
    public void test_getPosition_isValidPosition_Word() { // or True / Valid / PowerPoint

        Reader reader = new Reader(TEST_STRING);

        assertEquals(-1, reader.getPosition());

        for (int i = 0; i< TEST_STRING.length(); i++) {

            try {

                reader.read(); // ch is the next character to process, hah..
                assertEquals(i, reader.getPosition());


            } catch (Exception ignored) { // tl;dr but wr, ip

                // Will actually log somewhere/how while doing sweet, sweet suites
                System.out.println("Expected: " + i + ", got this instead: " + reader.getPosition() + ", eh?");
                // Have no idea what I am talking about actually

            }

        }

    }

    @Test
    public void test_getPosition_isValidPosition_Wordnt() {

        Reader reader = new Reader(TEST_STRING);

        assertEquals(-1, reader.getPosition());

        for (int i = 0; i< TEST_STRING.length(); i++) {

            try {

                reader.read(); // ch is the next character to process, heh..
                assertNotEquals(getRandomBetweenKekw(), reader.getPosition());


            } catch (Exception ignored) {

                System.out.println("Expected: " + i + ", got this instead: " + reader.getPosition() + ", eh?");

            }

        }

    }

    @Test
    public void test_read_isValidCharacter_Word() {

        Reader reader = new Reader(TEST_STRING);

        for (int i = 0; i< TEST_STRING.length(); i++) {

            try {

                char expectedChar = TEST_STRING.charAt(i);
                char actualChar = reader.read();

                assertEquals(expectedChar, actualChar);


            } catch (Exception ignored) {


            }

        }

    }

    @Test
    public void test_read_isInvalidCharacter_Wordnt() { // invalid != unexpected, but w/e

        Reader reader = new Reader(TEST_STRING);

        for (int i = 0; i< TEST_STRING.length(); i++) {

            try {

                char unexpectedChar;
                char actualChar = reader.read();

                do {

                    unexpectedChar = (char) getRandomBetweenKekw();

                } while (unexpectedChar == actualChar);

                assertNotEquals(unexpectedChar, actualChar);

            } catch (Exception ignored) {

            }

        }

    }

    public int getRandomBetweenKekw() {
        return (int) ((Math.random() * (420 - 69)) + 69); // the ctrl+rewrite but have read the surrounding text.. hah
    }


    // I know that I joke a lot


    // I joke, I joke,
    // I kid, I kid.

    // If I offend, I'm sorry,
    // Please, please, forgive.


    // For I have read somewhere that programming should be mandatory in schools
    // And with the fun I'm having, I hereby agree



    // Isn't it just logik with extra steps?

    // I'm not saying LLVM or stuff like that

    // I just believe that chatGPTz are not on the same tangent

    // And we shouldn't stray from skills to comfort that easily

    // Yours truly,
    // Unskilled&Lazy

}
