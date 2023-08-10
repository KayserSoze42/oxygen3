package ink.oxiemoron.controllers;

import ink.oxiemoron.lexicon.amgine.abstracta.AmgineEngine;
import ink.oxiemoron.lexicon.ast.AST;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.lexer.Lexer;
import ink.oxiemoron.lexicon.parser.Parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RCLIController {

    private AmgineEngine courierTransPiler; // just to watch
    private AmgineEngine porNeGrafTransPiler;//            maybe they'll do something on their own, for once...   smh..

    private StringBuffer source; // we shall see shell..
    private StringBuffer outsource;

    private static Lexer lexer;
    private static Parser parser;


    public RCLIController() {
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

    public static void main (String[] args) {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("----------------OXY----------------");

        while (true) {

            System.out.print("REPL>");

            try {

                String cmd = buffer.readLine();

                if (cmd.equals("end")) {break;}

// ---------------- << parser test repl only >> ----------------

                parser = new Parser(cmd);
                AST tree = parser.execute();

// ---------------- << lexer test repl only >> ----------------
//
//                lexer = new Lexer(cmd);
//                Token token = lexer.getNextToken();
//
//                while (token != null) {
//
//                    System.out.println("Token: " + token.getElement().getType() + " - " + token.toString());
//                    token = lexer.getNextToken();
//
//                }
//
// ---------------- << parser plex repl only >> ----------------
// 2ba

                System.out.println();
            } catch (Exception ioe) {

                System.out.println("A broad one..");

            }


        }
    }

}
