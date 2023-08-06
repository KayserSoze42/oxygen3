package ink.oxiemoron;

import ink.oxiemoron.controllers.RCLIController;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.lexer.Lexer;
import ink.oxiemoron.lexicon.parser.Parser;

public class Main {

    public static void main(String[] args) {

        RCLIController RCLIController = new RCLIController();

        System.out.println(RCLIController.plex("1,2,420,69-tetramethyl 8,8,8,8,8,8,8,8-octaoctyloctane;"));

        long start = System.currentTimeMillis();

        System.out.println("--------------------------------");
        System.out.println("LEXER:\n");

        try {

            Lexer lexer = new Lexer("1,2,420,69-tetramethyl 8,8,8,8,8,8,8,8-octaoctyloctane;"); // ignoring isomers for now, for sure

            Token tolkien = lexer.getNextToken();

            while (tolkien != null) {
                System.out.println("Token: " + tolkien.getElement().getType() + " - " + tolkien.toString());
                tolkien = lexer.getNextToken();
            }

        } catch (Exception eh) {

            System.out.println("Error, eh?");

        }

        System.out.println("--------------------------------");
        System.out.println("PARSER? ... Well, you know:\n");

        try {

            Parser parser = new Parser("9,6,024,21-tetraethylheptane;");

            for (int i = 0; i < 11; i++) {

                parser.scan();

            }

        } catch (Exception eh) {

            System.out.println("We meet again, eh?");
        }

        long end = System.currentTimeMillis();

        System.out.println("\n***\nRun Time: " + (end - start) + " ms");
    }

}
