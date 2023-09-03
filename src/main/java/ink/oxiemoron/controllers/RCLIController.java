package ink.oxiemoron.controllers;

import ink.oxiemoron.colexicon.lingua.OxyParserException;
import ink.oxiemoron.lexicon.amgine.abstracta.AmgineEngine;
import ink.oxiemoron.lexicon.parser.approach.ParserApproach;
import ink.oxiemoron.lexicon.reverbs.ast.AST;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.lexer.Lexer;
import ink.oxiemoron.lexicon.parser.appliance.lr.Parser;
import ink.oxiemoron.lexicon.visiteurs.PrintFVisiteur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RCLIController {

    private AmgineEngine courierTransPiler; // just to watch
    private AmgineEngine porNeGrafTransPiler;//            maybe they'll do something on their own, for once...   smh..

    private StringBuilder outsource;

    private static Lexer lexer;
    private static Parser parser;


    public RCLIController() {
        outsource = new StringBuilder();
    }



    public String plex(ParserApproach parserApproach) {

        try {

            AST result = (AST) parserApproach.execute(); // ... don't judge me ...

            PrintFVisiteur printFVisiteur = new PrintFVisiteur();

            result.accept(printFVisiteur);


        } catch (Exception eh) {

            System.out.println("interesting..");

        }

        return outsource.toString();

    }

    public void rclicc() {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        AST tree = null;
        System.out.println("----------------OXY----------------");

        while (true) {


            try {

                if (tree != null) {
                    tree.resetTreeCounter();
                }

                System.out.print("REPL>");

                String cmd = buffer.readLine();

                if (cmd.equals("end")) {break;}

// ---------------- << parser test repl only >> ----------------

                parser = new Parser(cmd);
                tree = parser.execute();


                PrintFVisiteur printFVisiteur = new PrintFVisiteur();
                tree.accept(printFVisiteur);




//
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

            } catch (IOException ioe) {

                ioe.printStackTrace();

            } catch (OxyParserException ope) {

                // System.out.println(ope.getMessage());

            }


        }
    }

}
