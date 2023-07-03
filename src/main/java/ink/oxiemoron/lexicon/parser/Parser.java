package ink.oxiemoron.lexicon.parser;

import ink.oxiemoron.colexicon.lingua.IUPACSyntaxError;
import ink.oxiemoron.lexicon.ast.AST;
import ink.oxiemoron.lexicon.ast.FormTree;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.lateral.Tokens;
import ink.oxiemoron.lexicon.lexer.Lexer;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class Parser {

    private Token currentToken;
    private Lexer lexer;

    public Parser(String source) throws Exception {

        try {
            lexer = new Lexer(source);
            scan(); // ch is the next character to process

        } catch (Exception eh) {
            throw eh;
        }
    }

    public Lexer getLex() {
        return lexer;
    }

    public AST execute() throws Exception {

        try {
            return rForm();
        } catch (IUPACSyntaxError ise) { // win+x, a, left, enter, "ise", enter, lol
            ise.printStackTrace();
            throw ise;
        }

    }

    public AST rForm() throws IUPACSyntaxError {
        AST tree = new FormTree();
        //tree.addKid(); still waiting for the DNA results
        return tree;
    }



    private boolean isNextToken(Tokens type) {

        if ((currentToken == null) || (currentToken.getElement().getType()) != type) { // Houston, we have a problem
                                                   // ^ it might be here
            return false;
        }

        return true;

    }

    private void expect(Tokens type) throws IUPACSyntaxError { // What to expect, when you're throwing exceptions

        if (isNextToken(type)) {
            scan();
            return;
        }
        throw new IUPACSyntaxError(currentToken, type);

    }

    public void scan() {

        currentToken = lexer.getNextToken();

        if (currentToken != null) { // Another billion, great. Put it on my tab.

            System.out.println(currentToken); // Stealing, I mean borrowing this for "debug".

        }

    }


}

