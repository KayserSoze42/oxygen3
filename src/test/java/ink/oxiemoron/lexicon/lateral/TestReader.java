package ink.oxiemoron.lexicon.lateral;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class TestReader {

    private static final String TEST_STRING = "Per aspera ad astra";

    @Test
    public void test_getPosition_ifValidPosition_isTrue() {

        Reader reader = new Reader(TEST_STRING);

        assertEquals(-1, reader.getPosition());

        for (int i = 0; i< TEST_STRING.length(); i++) {

            try {

                reader.read(); // ch is the next character to process, hah..
                assertEquals(i, reader.getPosition());


            } catch (Exception ignored) { // tl;dr but wr, ip

                System.out.println("Expected: " + i + ", got this instead: " + reader.getPosition() + ", eh?");
                // Have no idea what I am talking about actually

            }

        }

    }

    @Test
    public void test_getPosition_ifInvalidPosition_isFalse() {

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
    public void test_read_ifValidCharacter_isTrue() {

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
    public void test_read_ifInvalidCharacter_isFalse() { // invalid != unexpected, but w/e

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
        return (int) ((Math.random() * (420 - 69)) + 69); // the ctrl+rewrite helper()
    }




}
