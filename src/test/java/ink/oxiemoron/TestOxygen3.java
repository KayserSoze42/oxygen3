package ink.oxiemoron; //                    º                  º                             º                 º
//         º              º  º                   º                 º            º       º                    º                             º
import org.junit.jupiter.api.Test; //         º          º                                         º
import static org.junit.jupiter.api.Assertions.assertEquals; //            º                              º                   º               º              º
import static org.junit.jupiter.api.Assertions.assertNotEquals; //   º            º                   º         º

// so the nam con i am going with (for now) is            º            º              º            *
//                                                                           º                 *                     º
// test_methodName_stateUnderTest_expectedBehaviour    º      º        º                   *                                     º                    º
//                                                                                      * *   *  *              º
// I hereby dub thee         º      º              º                  º                *
//                                                                                          *  *
// the_teleScope_testIng_semaNtics()  º                       º              º            *      *                   º               º
//                º                       º
// for the slight resemblance to a telescope, hah  ╚■■■████▓             º     º                        º          º
//                                                     ╬                                                                 º                         º
// grep, i adore using ascii             º             ║     º                     º                        º
//======================================================================================================================
//                                                                                                                       4NNM&dog™
//                                                                                                                       a low po(or)ly drawn tribute
// *sema actually means token, heh
public class TestOxygen3 { //

    @Test
    public void testTheTest() {

        int[] ints = {0x6A,0x75,0x6E,0x69,0x74,0x20,0x75,0x73,0x65,0x73,0x20,0x72,0x65,0x66,0x6C,0x65,0x63,0x74,0x2C,
                0x20,0x73,0x6F,0x20,0x69,0x20,0x6D,0x69,0x67,0x68,0x74,0x20,0x72,0x65,0x66,0x6C,0x65,0x63,0x74,0x20,
                0x74,0x6F,0x6F,0x2E,0x2E}; // overflow: auto; hah

        for (int integer : ints) {

            assertEquals(integer, integer); // "positive" test :)

            int notExpected = 0x420; // 69 is expected :/

            if (integer == 69) {

                System.out.println("Niceeee.."); // "i can't believe you've done this"

            }
            
            assertNotEquals(notExpected, integer); // "negative" test :(

            // still, i might be wrong (prbly(am(def(101%))))

        }
    }

}
