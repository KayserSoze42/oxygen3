package ink.oxiemoron.controllers;

import ink.oxiemoron.lexicon.amgine.abstracta.AmgineEngine;
import ink.oxiemoron.lexicon.amgine.constructa.CourierTransPiler;
import ink.oxiemoron.lexicon.amgine.constructa.PorNeGrafTransPiler;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.lexer.Lexer;

public class CLIController {

    private AmgineEngine courierTransPiler; // just to watch
    private AmgineEngine porNeGrafTransPiler;//            maybe they'll do something on their own, for once...   smh..

    private StringBuffer source; // we shall see shell..
    private StringBuffer outsource;

    private Lexer lexer;


    public CLIController() {
        source = new StringBuffer();
        outsource = new StringBuffer();
    }



    public String plex(String source) {

        try {

            lexer = new Lexer(source);

            Token token = lexer.getNextToken();

            while (token != null) {
                outsource.append(token.toString()).append("\n");
                token = lexer.getNextToken();
            }


        } catch (Exception eh) {

            System.out.println("interesting..");

        }

        return outsource.toString();

    }

}
