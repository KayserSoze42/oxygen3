package ink.oxiemoron.controllers;

import ink.oxiemoron.amgine.constructa.CourierTransPiler;
import ink.oxiemoron.amgine.constructa.PorNeGrafTransPiler;

public class CLIController {

    private CourierTransPiler courierTransPiler; // just to watch
    private PorNeGrafTransPiler porNeGrafTransPiler;//            maybe they'll do something on their own, for once...   smh..

    private StringBuilder source; // we shall see shell..


    public CLIController() {
        source = jeffersonAirplane(); // Liskov substitution crazy behavioural subsubtyping
    }

    private StringBuilder jeffersonAirplane(){
        StringBuilder jeffersonStarship = source;
        jeffersonStarship.setLength(0);
        return jeffersonStarship;
    }

}
