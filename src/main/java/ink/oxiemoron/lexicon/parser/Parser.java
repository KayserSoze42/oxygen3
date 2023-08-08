package ink.oxiemoron.lexicon.parser;

import ink.oxiemoron.colexicon.lingua.IUPACSyntaxError;
import ink.oxiemoron.colexicon.lingua.OxyParserException;
import ink.oxiemoron.lexicon.ast.*;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.lateral.Tokens;
import ink.oxiemoron.lexicon.lexer.Lexer;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class Parser {

    private Token currentToken;
    private Lexer lexer;

    public Parser(String source) throws OxyParserException {

        try {
            lexer = new Lexer(source);
            scan(); // ch is the next character to process

        } catch (Exception eh) {
            throw new OxyParserException();
        }
    }

    public Lexer getLex() {
        return lexer;
    }

    public AST execute() throws Exception {

        try {

            return rForm();

        } catch (IUPACSyntaxError ise) {

            ise.printStackTrace();
            throw ise;

        }

    }

    public AST rForm() throws IUPACSyntaxError {
        AST tree = new FormTree();

        if (isNextToken(Tokens.Root)) {

            tree.addKid(rRoot());
            return tree;
        }

        do {

            tree.addKid(rSubstructureTree());

        } while (isNextToken(Tokens.Location) || isNextToken(Tokens.Radical));

        expect(Tokens.Root);
        tree.addKid(rRoot());

        return tree;
    }

    public AST rSubstructureTree() throws IUPACSyntaxError {

        AST tree = new SubstructureTree();

        if (isNextToken(Tokens.Location)) {

            tree.addKid(rSubstituentTree());

        }

        return tree;
    }

    public AST rSubstituentTree() throws IUPACSyntaxError {

        AST tree = new SubstituentTree();

        if (isNextToken(Tokens.Location)) {

            do {

                tree.addKid(rLocationTree());

                expect(Tokens.Comma);

            } while (isNextToken(Tokens.Location));

            expect(Tokens.Dash);
            expect(Tokens.Multiplier);

        }

        if (isNextToken(Tokens.Radical)) {



        }

        return tree;

    }

    public AST rLocationTree() throws IUPACSyntaxError {

        AST tree = new LocationTree(currentToken);
        scan();
        return tree;
    }

    public AST rRadical() throws IUPACSyntaxError {

        AST tree = new RadicalTree(currentToken);
        scan();
        return tree;
    }

    public AST rRoot() throws IUPACSyntaxError {
        return new RootTree(currentToken);
    }

    private boolean isNextToken(Tokens type) {

        if ((currentToken == null) || (currentToken.getElement().getType()) != type) {

            return false;
        }

        return true;

    }

    private void expect(Tokens type) throws IUPACSyntaxError {

        if (isNextToken(type)) {
            scan();
            return;
        }
        throw new IUPACSyntaxError(currentToken, type);

    }

    public void scan() {

        currentToken = lexer.getNextToken();

        if (currentToken != null) {

            System.out.println(currentToken);

        }

    }


}

