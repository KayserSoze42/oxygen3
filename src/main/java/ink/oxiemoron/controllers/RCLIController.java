package ink.oxiemoron.controllers;

import ink.oxiemoron.colexicon.lingua.OxyLexerException;
import ink.oxiemoron.colexicon.lingua.OxyParserException;
import ink.oxiemoron.lexicon.amgine.propellers.AmgineEngine;
import ink.oxiemoron.lexicon.lateral.basic.Token;
import ink.oxiemoron.lexicon.parser.approach.ParserApproach;
import ink.oxiemoron.lexicon.reverbs.ast.abstracta.AST;
import ink.oxiemoron.lexicon.lexer.appliance.basic.Lexer;
import ink.oxiemoron.lexicon.parser.appliance.basic.Parser;
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



    public void plex(ParserApproach parserApproach) {

        try {

            AST result = (AST) parserApproach.execute(); // ... don't judge me ...

            PrintFVisiteur printFVisiteur = new PrintFVisiteur();

            result.accept(printFVisiteur);


        } catch (Exception eh) {

            System.out.println("interesting..");

        }

    }

    public void lclicc() {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        AST tree = null;
        System.out.println("----------------OXY----------------");

        while (true) {


            try {

                if (tree != null) {
                    tree.resetTreeCounter();
                }

                System.out.print("LCLICC>");

                String cmd = buffer.readLine();

                if (cmd.equals("end")) {break;}

                lexer = new Lexer(cmd);
                Token token = lexer.getNextToken();

                while (token != null) {

                    System.out.println("Token: " + token.getElement().getType() + " - " + token.toString());
                    token = lexer.getNextToken();
                }

            } catch (IOException ioe) {

                ioe.printStackTrace();

            } catch (OxyLexerException ole) {
                // ole, i guess
            }


        }

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

                System.out.print("RCLICC>");

                String cmd = buffer.readLine();

                if (cmd.equals("end")) {break;}

                parser = new Parser(cmd);
                tree = parser.execute();


                PrintFVisiteur printFVisiteur = new PrintFVisiteur();
                tree.accept(printFVisiteur);


            } catch (IOException ioe) {

                ioe.printStackTrace();

            } catch (OxyParserException ope) {
                // and ope, i guess
            }


        }
    }

}
