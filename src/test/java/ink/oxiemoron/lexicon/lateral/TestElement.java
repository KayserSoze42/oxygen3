package ink.oxiemoron.lexicon.lateral;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestElement {

    @Test
    public void test_toString_ifValidReturn_isTrue() {

        String[] testStrings = new String[]{
                "a", "b", "c", "d", "q", "w", "e", "r", "r", "e", "q", "45⌡♠▒68{1⌡♠▒ß5⌡♠▒68{k╙W⌡♠▒"
        };

        for (String string : testStrings) {
            Element element = Element.craft(string, Tokens.Error);

            assertEquals(string, element.toString());
        }
    }

    @Test
    public void test_getType_ifValidType_isTrue() {

        for (Tokens token : Tokens.values()) {

            Element element = Element.craft(token.toString(), token);

            assertEquals(token, element.getType());

        }

    }

}
