import lexicon.lateral.Token;
import lexicon.lexer.Lexer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

            Lexer lexer = new Lexer("1,2,420,69-ditest"); // By now I feel that at least 69% of my code has this joke

            Token token = lexer.getNextToken();

            while (token != null) {
                System.out.println("Token: " + token.getElement().getType() + " - " + token.toString());
                token = lexer.getNextToken();
            }

        } catch (Exception eh) {

            System.out.println("Error, eh?");

        }





    }

}
