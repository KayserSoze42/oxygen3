package ink.oxiemoron.lexicon.amgine.constructa.interpiler;

import ink.oxiemoron.colexicon.metils.Pile;
import ink.oxiemoron.lexicon.amgine.constructa.interpiler.Piler.Climate;

import java.util.List;

public class InterPiler {

    private Piler piler;
    private List<PlainThreadSerialData> ptsds;


    public InterPiler() {

    }

    public static class PlainThreadSerialData {

        public Pile<Climate> climatePile;
// --
        InterState interState;

        public PlainThreadSerialData(Pile<Climate> climatePile, InterState interState) {

            this.climatePile = climatePile;
            this.interState = interState;

        }

    }
}
