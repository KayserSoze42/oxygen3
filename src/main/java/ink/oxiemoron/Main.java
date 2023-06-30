package ink.oxiemoron;

import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.lexer.Lexer;
import ink.oxiemoron.lexicon.parser.Parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("--------------------------------");
        System.out.println("LEXER:\n");

        try {

            Lexer lexer = new Lexer("1,2,420,69-tetra"); // By now I feel that at least 69% of my code has this joke

            Token token = lexer.getNextToken();

            while (token != null) {
                System.out.println("Token: " + token.getElement().getType() + " - " + token.toString());
                token = lexer.getNextToken();
            }

        } catch (Exception eh) {

            System.out.println("Error, eh?");

        }

        System.out.println("--------------------------------");
        System.out.println("PARSER? ... Well, you know:\n");

        try {

            Parser parser = new Parser("9,6,024,21-tetra");

            for (int i = 0; i < 8; i++) {

                parser.scan();

            }

        } catch (Exception eh) {

            System.out.println("We meet again, eh?");
        }






    }

}
