package ink.oxiemoron.colexicon.metils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCarrier {

    @Test
    public void test_size_ifEmpty_isEmpty(){

        Carrier<Object> carrier = new Carrier<>();

        assertEquals(0, carrier.size());

    }

    // playin' before suiting up


}
