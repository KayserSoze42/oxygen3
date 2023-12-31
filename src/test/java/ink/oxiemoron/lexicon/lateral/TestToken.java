package ink.oxiemoron.lexicon.lateral;

import ink.oxiemoron.lexicon.lateral.basic.Element;
import ink.oxiemoron.lexicon.lateral.basic.Token;
import ink.oxiemoron.lexicon.lateral.basic.Tokens;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestToken {

    @Test
    public void test_getElement_ifValid_isTrue() {

        for (Tokens tokenType : Tokens.values()) {
            Element element = Element.craft(tokenType.toString(), tokenType);

            Token token = new Token(0,0, element);

            assertEquals(element, token.getElement());
        }
    }

    @Test
    public void test_getLeft_ifValid_isTrue() {

        Element element = Element.craft("dummy", Tokens.Root);

        for (int i=0; i<69; i++) {
            Token token = new Token(i, i+1, element);

            assertEquals(i, token.getLeft());
        }

    }

    @Test
    public void test_getLeft_ifInvalid_isFalse() {

        Element element = Element.craft("dummy", Tokens.Root);

        for (int i=0; i<69; i++) {
            Token token = new Token(i, i+1, element);

            assertNotEquals(i+1, token.getLeft());
        }

    }

    @Test
    public void test_getRight_ifValid_isTrue() {

        Element element = Element.craft("dummy", Tokens.Root);

        for (int i=0; i<69; i++) {
            Token token = new Token(i, i+1, element);

            assertEquals(i+1, token.getRight());
        }

    }

    @Test
    public void test_getRight_ifInvalid_isFalse() {

        Element element = Element.craft("dummy", Tokens.Root);

        for (int i=0; i<69; i++) {
            Token token = new Token(i, i+1, element);

            assertNotEquals(i, token.getRight());
        }

    }

}
