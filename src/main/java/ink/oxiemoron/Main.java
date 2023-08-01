package ink.oxiemoron;

import ink.oxiemoron.colexicon.metils.Pile;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.lateral.regex.Regex;
import ink.oxiemoron.lexicon.lexer.Lexer;
import ink.oxiemoron.lexicon.parser.Parser;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        System.out.println("--------------------------------");
        System.out.println("LEXER:\n");

        try {

            Lexer lexer = new Lexer("1,2,420,69-tetramethyldecane;"); // ignoring isomers for now, for sure

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

            Parser parser = new Parser("9,6,024,21-tetraethylheptane;"); // Oh. Play it cool. Play it cool.
            // Here come the whitespace cops
            // Whitespaaaaace

            for (int i = 0; i < 11; i++) {

                parser.scan();

            }

        } catch (Exception eh) {

            System.out.println("We meet again, eh?");
        }
    }

}
